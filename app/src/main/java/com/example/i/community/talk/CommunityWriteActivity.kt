package com.example.i.community.talk

import android.R
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.customdialog.CMCategoryDialog
import com.example.i.community.talk.models.*
import com.example.i.config.ApplicationClass
import com.example.i.databinding.ActivityCommunityWriteBinding
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.io.File


class CommunityWriteActivity : AppCompatActivity(), View.OnClickListener, FeedsWriteInterface, FeedsWriteImageInterface, FeedsEditInterface {
    private lateinit var viewBinding: ActivityCommunityWriteBinding
    private var title: String = ""
    private var content: String = ""
    private var category: String = ""
    private var boardId : Int = 0
    private var roomType : Int = 0
    private var userId : Int = 33
    private var imgCnt : Int = 0
    private var feedIdx : Int = -1
    private lateinit var recyclerView: RecyclerView
    private lateinit var writeImageAdapter: WriteImageAdapter
    private var imageList : ArrayList<Uri> = ArrayList()
    private var files : ArrayList<File> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        //이미지 업로드
        writeImageAdapter = WriteImageAdapter(imageList, this)
        recyclerView = viewBinding.rvPhoto
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = writeImageAdapter

        //업로드 버튼 클릭 리스너
        val imageButton = viewBinding.clPhoto

        imageButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            activityResult.launch(intent)
        }




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

                if(category == "수다방" || category == "질문방" || category == "정보방"){
                    boardId = 1
                    if(category == "수다방"){
                        roomType = 1
                    }
                    else if(category == "질문방"){
                        roomType = 2
                    }
                    else if(category == "정보방"){
                        roomType = 3
                    }
                }
                else if(category == "간호 일기" || category == "무지개 일기"){
                    boardId = 2
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

        //업로드
        viewBinding.btUpload.setOnClickListener {
            val title = viewBinding.etTitle.text.toString()
            val content = viewBinding.etContent.text.toString()
            val imgCnt = imageList.size
            val boardIdx = boardId
            val roomType = roomType
            val userIdx = userId
            val imageList = imageList
            val feedIdx = feedIdx

            if(feedIdx == -1){


            if (imageList.size == 0) {
                val postRequest = PostFeedsWriteRequest(
                    title = title,
                    content = content,
                    boardIdx = boardIdx,
                    roomType = roomType,
                    userIdx = userIdx
//                    imgCnt = 0,
                )
                FeedsWriteService(this).tryPostFeedsWrite(postRequest)
            } else {
                val service =
                    ApplicationClass.sRetrofit.create(FeedsWriteImageRetrofitInterface::class.java)
                if (imageList.size != 0) {
                    val file = File(getRealPathFromURI(imageList[0]))
                    val requestFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
                    val image = MultipartBody.Part.createFormData("image", file.name, requestFile)
                    val requestBody =
                        PostFeedsWriteRequest(userIdx, boardIdx, roomType, title, content)
                    val requestJson = Gson().toJson(requestBody)
                    val request = requestJson.toRequestBody("application/json".toMediaTypeOrNull())
                    val call = service.postFeedsImageWrite(request, image)
                    call.enqueue(object : Callback<FeedsWriteImageResponse> {
                        override fun onResponse(
                            call: Call<FeedsWriteImageResponse>,
                            response: Response<FeedsWriteImageResponse>
                        ) {
                            (response.body() as FeedsWriteImageResponse?)?.let {
                                onPostFeedsImageWriteSuccess(it)
                            }
                        }

                        override fun onFailure(call: Call<FeedsWriteImageResponse>, t: Throwable) {
                            onPostFeedsImageWriteFailure(t.message ?: "통신 오류")
                        }
                    })
                } else {

                }
            }
//                val images = ArrayList<MultipartBody.Part>()
//                for (i in 0 until imageList.size) {
//                    val file = File(getRealPathFromURI(imageList[i]))
//                    val requestFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
//                    images.add(MultipartBody.Part.createFormData("image$i", file.name, requestFile))
//                }
//                FeedsWriteImageService(this).sendPostFeedsWriteRequest(request, image)
            }
            else{
                val patchRequest = PatchFeedsEditRequest(
                    feedIdx = feedIdx,
                    title = title,
                    content = content,
                    boardIdx = boardIdx,
                    roomType = roomType,
                    userIdx = userIdx
                )
                FeedsEditService(this).tryPatchFeedsEdit(patchRequest)

            }
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }

    //이미지 갤러리에서 가져오기
    private val activityResult : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            if(it.data!!.clipData != null){
                val count = it.data!!.clipData!!.itemCount
                for(index in 0 until count){
                    val imageUri = it.data!!.clipData!!.getItemAt(index).uri
                    val file = File(absolutelyPath(imageUri, this))
                    imageList.add(imageUri)
                    files.add(file)
                }
            }else{
                val imageUri = it.data!!.data
                imageList.add(imageUri!!)
            }
            viewBinding.tvCount.text = imageList.size.toString()
            writeImageAdapter.notifyDataSetChanged()
        }
    }
    fun absolutelyPath(path: Uri?, context : Context): String {
        var proj: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        var c: Cursor? = context.contentResolver.query(path!!, proj, null, null, null)
        var index = c?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        c?.moveToFirst()

        var result = c?.getString(index!!)

        return result!!
    }


    override fun onPostFeedsWriteSuccess(response: FeedsWriteResponse) {
        if(response.isSuccess){
            finish()
            response.message?.let{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }else{
        }
    }


    override fun onPostFeedsWriteFailure(message: String) {
        Toast.makeText(this, "오류 $message", Toast.LENGTH_SHORT).show()
    }

    override fun onPostFeedsImageWriteSuccess(response: FeedsWriteImageResponse) {
        if(response.isSuccess){
            finish()
            response.message?.let{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }else
        {

        }
    }

    override fun onPostFeedsImageWriteFailure(message: String) {
        Toast.makeText(this, "오류 $message", Toast.LENGTH_SHORT).show()
    }

    override fun onPatchFeedsEditSuccess(response: FeedsWriteResponse) {
        if(response.isSuccess){
            finish()
            response.message?.let{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        }else
        {

        }
    }

    override fun onPatchFeedsEditFailure(message: String) {
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
}