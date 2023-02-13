package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.i.config.BaseResponse
import com.example.i.databinding.ActivityRevokeBinding
import com.example.i.login.memIdx
import com.example.i.mypage.customdialog.PopupRevokeDialog
import com.example.i.mypage.data.*

class RevokeActivity : AppCompatActivity(), RevokeInterface {
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

            // 서버에 값 보냄
            // val postRequest = PostRevokeRequest(33)
            RevokeService(this).tryPostRevoke(memIdx)
        }
    }
    // 탈퇴하기 API
    override fun onPostRevokeSuccess(response: BaseResponse) {
        // Result message
        response.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }

    // 서버 연결 실패
    override fun onPostRevokeFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}