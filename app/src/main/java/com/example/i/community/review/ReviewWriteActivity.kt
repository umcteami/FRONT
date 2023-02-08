package com.example.i.community.review

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.UploadPhotoActivity
import com.example.i.databinding.ActivityReviewWriteBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReviewWriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewWriteBinding
    private var trader : String = ""
    private var content : String = ""
    private var category : String = ""
    private var userId : Int? = null
    private var imgCnt : Int? = null
    var retrofit = Retrofit.Builder()
        .baseUrl("www.iandpet.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btUpload.setOnClickListener{
            val uploadIntent = Intent(this, ReviewActivity::class.java)
            startActivity(uploadIntent)
        }

        viewBinding.btCamera.setOnClickListener {
            val cameraIntent = Intent(this, UploadPhotoActivity::class.java)
            startActivity(cameraIntent)
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.etId.addTextChangedListener(object:TextWatcher{
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
        viewBinding.etId.addTextChangedListener(object:TextWatcher{
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
        viewBinding.etId.addTextChangedListener(object:TextWatcher{
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
        viewBinding.btBack.setOnClickListener{
            finish()
        }
    }
}
