package com.example.i.community.review

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.review.models.PostReviewWriteRequest
import com.example.i.community.review.models.ReviewWriteInterface
import com.example.i.community.review.models.ReviewWriteResponse
import com.example.i.community.review.models.ReviewWriteService
import com.example.i.databinding.ActivityReviewWriteBinding

class ReviewWriteActivity : AppCompatActivity(), ReviewWriteInterface {
    private lateinit var viewBinding: ActivityReviewWriteBinding
    private var trader: String = ""
    private var content: String = ""
    private var category: String = ""
    private var userId: Int? = null
    private var imgCnt: Int = 0
    private var imageList : ArrayList<Uri> = ArrayList()


     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

//        viewBinding.btUpload.setOnClickListener{
//            val uploadIntent = Intent(this, ReviewActivity::class.java)
//            startActivity(uploadIntent)
//        }

        viewBinding.btCamera.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            activityResult.launch(intent)
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                category = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && category.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                category = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && category.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                trader = viewBinding.etId.text.toString()
                category = viewBinding.etKind.text.toString()
                content = viewBinding.etContent.text.toString()

                viewBinding.btUpload.isEnabled =
                    trader.isNotEmpty() && content.isNotEmpty() && category.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewBinding.btBack.setOnClickListener {
            finish()
        }

        viewBinding.btUpload.setOnClickListener {
            val content = viewBinding.etContent.text.toString()
            val goods = viewBinding.etKind.text.toString()
            val imgCount = imgCnt
            val postRequest = PostReviewWriteRequest(
                buyerIdx = 0, sellerIdx = 0, content = content, goods = goods, imgCnt = imgCount
            )
            ReviewWriteService(this).tryPostReviewWrite(postRequest)
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
//                viewBinding.ivUplodaImage.setImageURI(imageUri)
            }
        }
    }

    override fun onPostReviewWriteSuccess(response: ReviewWriteResponse) {
        if (response.isSuccess) {
            val intent = Intent(this, ReviewActivity::class.java)
            this.startActivity(intent)
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
