package com.example.i.community.talk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.UploadPhotoActivity
import com.example.i.community.customdialog.CMCategoryDialog
import com.example.i.community.talk.models.FeedsWriteInterface
import com.example.i.community.talk.models.FeedsWriteResponse
import com.example.i.community.talk.models.FeedsWriteService
import com.example.i.community.talk.models.PostFeedsWriteRequest
import com.example.i.databinding.ActivityCommunityWriteBinding

class CommunityWriteActivity : AppCompatActivity(), View.OnClickListener, FeedsWriteInterface {
    private lateinit var viewBinding: ActivityCommunityWriteBinding
    private val REQUEST_CODE = 1000
    private var title: String = ""
    private var content: String = ""
    private var category: String = ""
    private var boardId : Int = 0
    private var roomType : Int = 0
    private var userId : Int = 30
    private var imgCnt : Int = 0
    private val imageUri = getImageUri()


    private fun getImageUri(): Uri {
        return imageUri
    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
//            val croppedImageUri = data?.getStringExtra("croppedImageUri")
//            if(!TextUtils.isEmpty(croppedImageUri)){
//                val uri = Uri.parse(croppedImageUri)
//                imageView.setImageURI(uri)
//
//            }
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btCamera.setOnClickListener {
            val cameraIntent = Intent(this, UploadPhotoActivity::class.java)
            cameraIntent.putExtra("imageUri", imageUri.toString())
            startActivity(cameraIntent)
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.btChoiceCategory.setOnClickListener(this)

        viewBinding.etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                category = viewBinding.btChoiceCategory.text.toString()

                viewBinding.btUpload.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리 선택")
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        viewBinding.etContent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                category = viewBinding.btChoiceCategory.text.toString()

                viewBinding.btUpload.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리 선택")

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        viewBinding.btChoiceCategory.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                category = viewBinding.btChoiceCategory.text.toString()

                viewBinding.btUpload.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리 선택")

                if(category == "수다방" || category == "질문방" || category == "이야기방"){
                    boardId = 1
                    if(category == "수다방"){
                        roomType = 1
                    }
                    else if(category == "질문방"){
                        roomType = 2
                    }
                    else if(category == "이야기방"){
                        roomType = 3
                    }
                }
                else if(category == "간호 일기" || category == "무지개 일기"){
                    boardId = 1
                    if(category == "간호 일기"){
                        roomType = 1
                    }
                    else if(category == "무지개 일기"){
                        roomType = 2
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.btUpload.setOnClickListener {
            val title = viewBinding.etTitle.text.toString()
            val contents = viewBinding.etContent.text.toString()
            val imgCnt = imgCnt
            val boardIdx = boardId
            val roomType = roomType
            val userIdx = userId

            if(imgCnt == 0){
                val postRequest = PostFeedsWriteRequest(
                    title = title, contents = contents, boardIdx = boardIdx, rommType = roomType, userIdx = userIdx, imgCnt = imgCnt
                )
                FeedsWriteService(this).tryPostFeedsWrite(postRequest)
            }
            else{

            }

            val uploadIntent = Intent(this, CommunityTalkroomActivity::class.java)
            startActivity(uploadIntent)
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }

    override fun onPostFeedsWriteSuccess(response: FeedsWriteResponse) {
        if(response.isSuccess){
            val intent = Intent(this, CommunityTalkroomActivity::class.java)
            this.startActivity(intent)
            response.message?.let{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }else{

        }
    }
    override fun onPostFeedsWriteFailure(message: String) {
        Toast.makeText(this, "오류 $message", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            viewBinding.btChoiceCategory.id -> {
                val dlg = CMCategoryDialog(this)
                dlg.setOnOkClickedListener { cText ->
                    viewBinding.btChoiceCategory.text = cText
                    title = viewBinding.etTitle.text.toString()
                    content = viewBinding.etContent.text.toString()
                    category = viewBinding.btChoiceCategory.text.toString()

                    viewBinding.btUpload.isEnabled =
                        title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리 선택")
                }
                dlg.show()
            }

        }
    }
}