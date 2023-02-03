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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        viewBinding.btCatagory.setOnClickListener(this)

        viewBinding.etPrice.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var price = viewBinding.etPrice.text!!

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
    }

    override fun onClick(view:View?) {
        when(view?.id) {
            viewBinding.btCatagory.id -> {
                val dlg = CatagoryDialog(this)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.tvCatagory.text = content
                }
                dlg.show()
            }
        }
    }

}