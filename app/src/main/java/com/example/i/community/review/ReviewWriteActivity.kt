package com.example.i.community.review

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.review.models.*
import com.example.i.community.talk.WriteImageAdapter
import com.example.i.config.ApplicationClass
import com.example.i.databinding.ActivityReviewWriteBinding
import com.example.i.login.memIdx
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class ReviewWriteActivity : AppCompatActivity(), ReviewWriteInterface {
    private lateinit var viewBinding: ActivityReviewWriteBinding
    private lateinit var writeImageAdapter : WriteImageAdapter
    private lateinit var recyclerView: RecyclerView
    private var trader: String = ""
    private var content: String = ""
    private var goods: String = ""
    private var userId: Int = 33
    private var imgCnt: Int = 0
    private var sellerIdx : Int = 33
    private var buyerIdx : Int = 30
    private var imageList : ArrayList<Uri> = ArrayList()


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        writeImageAdapter = WriteImageAdapter(imageList, this)
        recyclerView = viewBinding.rvPhoto
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = writeImageAdapter

        viewBinding.clPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            activityResult.launch(intent)
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                goods = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && goods.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.etKind.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                goods = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && goods.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.etContent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                goods = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && goods.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        //장터후기 게시글 업로드
        viewBinding.btUpload.setOnClickListener {
            val content = viewBinding.etContent.text.toString()
            val goods = viewBinding.etKind.text.toString()
            val sellerIdx = sellerIdx
            val buyerIdx = memIdx
            Toast.makeText(this,"buttonCLck",Toast.LENGTH_SHORT).show()
            val postReviewWriteRequest = PostReviewWriteRequest(sellerIdx, buyerIdx, goods, content)
            if(imageList.size == 0)
            {
                //이미지가 없을 경우
                val emptyImage = RequestBody.create("image/jpeg".toMediaTypeOrNull(), ByteArray(0))
                val image = MultipartBody.Part.createFormData("img", "image.jpg", emptyImage)
                val images = listOf(image)
                ReviewWriteService(this).tryPostReviewWrite(postReviewWriteRequest, images)
            }
            else{
                val images = ArrayList<MultipartBody.Part>()
                for(i in 0 until imageList.size){
                    val file = File(getRealPathFromURI(imageList[i]))
                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    images.add(MultipartBody.Part.createFormData("img", file.name, requestFile))
                }
                ReviewWriteService(this).tryPostReviewWrite(postReviewWriteRequest, images)
            }
        }
    }

    private val activityResult : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            if(it.data!!.clipData != null){
                val count = it.data!!.clipData!!.itemCount
                for(index in 0 until count){
                    val imageUri = it.data!!.clipData!!.getItemAt(index).uri
                    imageList.add(imageUri)
                }
            }
            else{
                val imageUri = it.data!!.data
                imageList.add(imageUri!!)
            }
            viewBinding.tvCount.text = imageList.size.toString()
            writeImageAdapter.notifyDataSetChanged()
        }
    }
    fun getRealPathFromURI(path: Uri): String {
        var cursor: Cursor? = null
        try {
            val proj = arrayOf(MediaStore.Images.Media.DATA)
            cursor = contentResolver.query(path , proj, null, null, null)
            val columnIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor.moveToFirst()
            return cursor.getString(columnIndex)
        } finally {
            cursor?.close()
        }
    }

    override fun onPostReviewWriteSuccess(response: ReviewWriteResponse) {
        if (response.isSuccess) {
            finish()
            response.message?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "글 작성에 실패했습니다", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onPostReviewWriteFailure(message : String) {
        Toast.makeText(this, "오류 $message", Toast.LENGTH_SHORT).show()
    }
}
