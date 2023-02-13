package com.example.i.market

import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission.Write
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.i.Main2Activity
import com.example.i.community.talk.WriteImageAdapter
import com.example.i.databinding.ActivityWriteBinding
import com.example.i.market.customdialog.CategoryDialog
import com.example.i.market.model.MarketWriteInterface
import com.example.i.market.model.MarketWriteResponse
import com.example.i.market.model.MarketWriteService
import com.example.i.market.model.PostMarketWriteRequest
import com.google.gson.annotations.SerializedName
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class WriteActivity : AppCompatActivity(), View.OnClickListener, MarketWriteInterface{
    private lateinit var viewBinding: ActivityWriteBinding
    private lateinit var writeImageAdapter : WriteImageAdapter
    private lateinit var recyclerView: RecyclerView
    private var title: String = ""
    private var price: String = ""
    private var content: String = ""
    private var catagory: String = ""
    private var userId : Int = 33
    private var imageList : ArrayList<Uri> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        writeImageAdapter = WriteImageAdapter(imageList, this)
        recyclerView = viewBinding.rvPhoto
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = writeImageAdapter

        viewBinding.clPhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
//            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true)
            activityResult.launch(intent)
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        viewBinding.btUpload.isEnabled = false
        viewBinding.btCategory.setOnClickListener(this)

        viewBinding.etTitle.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                price = viewBinding.etPrice.text!!.toString()
                content = viewBinding.etContent.text.toString()
                catagory = viewBinding.btCategory.text.toString()

                viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewBinding.etPrice.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                price = viewBinding.etPrice.text!!.toString()
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                catagory = viewBinding.btCategory.text.toString()

                viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")

                if (price.isEmpty() == true) {
                    viewBinding.tvPrice.setTextColor(Color.rgb(0xA6,0xA6,0xA6))
                } else{
                    viewBinding.tvPrice.setTextColor(Color.BLACK)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewBinding.cbShare.setOnCheckedChangeListener { compoundButton, b ->
            if(b) {
                viewBinding.etPrice.setText("0")
            }
            else {
                viewBinding.etPrice.setText("")
            }
        }

        viewBinding.etContent.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                price = viewBinding.etPrice.text!!.toString()
                content = viewBinding.etContent.text.toString()
                catagory = viewBinding.btCategory.text.toString()

                viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewBinding.btUpload.setOnClickListener {
            val title = viewBinding.etTitle.text.toString()
            val content = viewBinding.etContent.text.toString()
            val userIdx = userId
            val price = viewBinding.etPrice.text.toString().toInt()
            val category = viewBinding.btCategory.text.toString()
            var numCategory : String = "1"

            when(category){
                "맘마/까까" -> numCategory = "1"
                "장난감" -> numCategory = "2"
                "영양제/약/간호용품" -> numCategory = "3"
                "기타" -> numCategory = "4"
            }

            val postRequest = PostMarketWriteRequest(
                title = title, content = content, price = price, userIdx = userIdx, category = numCategory
            )
            if(imageList.size == 0)
            {
                //이미지가 없을 경우
                val emptyImage = RequestBody.create("image/jpeg".toMediaTypeOrNull(), ByteArray(0))
                val image = MultipartBody.Part.createFormData("images", "image.jpg", emptyImage)
                val images = listOf(image)
                MarketWriteService(this).tryPostMarketWrite(postRequest, images)
            }
            else{
                //이미지가 있을 경우
                val images = ArrayList<MultipartBody.Part>()
                for(i in 0 until imageList.size){
                    val file = File(getRealPathFromURI(imageList[i]))
                    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
                    images.add(MultipartBody.Part.createFormData("images", file.name, requestFile))
                }
                MarketWriteService(this).tryPostMarketWrite(postRequest, images)
            }
        }
    }

    override fun onPostMarketWriteSuccess(response: MarketWriteResponse) {
        if(response.isSuccess){
            finish()
        }
        else{

        }
    }

    override fun onPostMarketWriteFailure(message: String) {
        Toast.makeText(this, "오류 $message", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view:View?) {
        when(view?.id) {
            viewBinding.btCategory.id -> {
                val dlg = CategoryDialog(this)
                dlg.setOnOkClickedListener { cText ->
                    viewBinding.btCategory.text = cText

                    title = viewBinding.etTitle.text.toString()
                    price = viewBinding.etPrice.text!!.toString()
                    content = viewBinding.etContent.text.toString()
                    catagory = viewBinding.btCategory.text.toString()

                    viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")
                }
                dlg.show()
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

}