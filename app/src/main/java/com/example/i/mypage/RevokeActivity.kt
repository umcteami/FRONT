package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityRevokeBinding
import com.example.i.mypage.customdialog.PopupRevokeDialog

class RevokeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityRevokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRevokeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btCall.isEnabled = false

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        viewBinding.acceptBtn.setOnClickListener {
            viewBinding.btCall.isEnabled = viewBinding.acceptBtn.isChecked
        }

        viewBinding.btCall.setOnClickListener {
            val dialog = PopupRevokeDialog()
            dialog.show(supportFragmentManager, "custom dialog")
        }

    }
}