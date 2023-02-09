package com.example.i.market

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.i.Main2Activity
import com.example.i.databinding.ActivityWriteBinding
import com.example.i.market.customdialog.CategoryDialog
import com.example.i.market.model.MarketWriteInterface
import com.example.i.market.model.MarketWriteResponse
import com.example.i.market.model.MarketWriteService
import com.example.i.market.model.PostMarketWriteRequest
import com.google.gson.annotations.SerializedName

class WriteActivity : AppCompatActivity(), View.OnClickListener, MarketWriteInterface{

    private lateinit var viewBinding: ActivityWriteBinding
    private var title: String = ""
    private var price: String = ""
    private var content: String = ""
    private var catagory: String = ""
    private var userId : Int = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

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
            val images = Images()
            val postRequest = PostMarketWriteRequest(
                title = title, content = content, price = price, userIdx = userIdx, category = category, images = images
            )
            MarketWriteService(this).tryPostMarketWrite(postRequest)

//                    @SerializedName("userIdx") val userIdx : Int,
//            @SerializedName("title") val title : String,
//            @SerializedName("category") val category : String,
//            @SerializedName("price") val price : Int,
//            @SerializedName("content") val content : String,
//            @SerializedName("images") val images : MediaStore.Images
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

}