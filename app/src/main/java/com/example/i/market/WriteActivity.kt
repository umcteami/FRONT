package com.example.i.market

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.i.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewBinding: ActivityWriteBinding
    private var title: String = ""
    private var price: String = ""
    private var content: String = ""
    private var catagory: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.btCatagory.setOnClickListener(this)

        viewBinding.etTitle.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                price = viewBinding.etPrice.text!!.toString()
                content = viewBinding.etContent.text.toString()
                catagory = viewBinding.btCatagory.text.toString()

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
                catagory = viewBinding.btCatagory.text.toString()

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
                catagory = viewBinding.btCatagory.text.toString()

                viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        viewBinding.btUpload.setOnClickListener {
            finish()
        }
    }

    override fun onClick(view:View?) {
        when(view?.id) {
            viewBinding.btCatagory.id -> {
                val dlg = CategoryDialog(this)
                dlg.setOnOkClickedListener { cText ->
                    viewBinding.btCatagory.text = cText

                    title = viewBinding.etTitle.text.toString()
                    price = viewBinding.etPrice.text!!.toString()
                    content = viewBinding.etContent.text.toString()
                    catagory = viewBinding.btCatagory.text.toString()

                    viewBinding.btUpload.isEnabled = title.isNotEmpty() && price.isNotEmpty() && content.isNotEmpty() && catagory != ("카테고리")
                }
                dlg.show()
            }
        }
    }

}