package com.example.i.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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