package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityMypageSettingBinding
import com.example.i.login.AccountSearchFragment
import com.example.i.login.NewPwFragment
import com.example.i.mypage.data.SettingInterface
import com.example.i.mypage.data.SettingRequest
import com.example.i.mypage.data.SettingResponse
import com.example.i.mypage.data.SettingService



class mypageSettingActivity : AppCompatActivity(), SettingInterface {
    private lateinit var viewBinding: ActivityMypageSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypageSettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 툴바 뒤로가기 -> 첫 화면으로 이동
       viewBinding.backBtn.setOnClickListener {
            finish()
        }

        // 생일
        viewBinding.changeBirth.setOnClickListener {
            viewBinding.editBrith.isEnabled = true

        }
        // 전화번호
        viewBinding.changeCall.setOnClickListener {
            viewBinding.editCall.isEnabled = true
        }
        // 이메일
        viewBinding.changeEmail.setOnClickListener {
            viewBinding.editEmail.isEnabled = true
        }

        // 비번 재설정
        viewBinding.editPwd.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, NewPwFragment())
                .commit()
        }


        // 회원정보 수정
        viewBinding.mypageSaveChange.setOnClickListener {
            // 서버에 값 보냄
            val email = viewBinding.editEmail.toString()
            val phone = viewBinding.editCall.toString()
            val nick = viewBinding.editNickName.toString()
            val intro = viewBinding.editIntroduce.toString()
            val birth = viewBinding.editBrith.toString()
            val addresCode = viewBinding.editAddressNum.toString()
            val addres = viewBinding.editAddress.toString()
            val addresPlus = viewBinding.editAddress2.toString()

            val settingRequest = SettingRequest(email = email, phone = phone, nick = nick, intro = intro,
                birth = birth, addresCode = addresCode, addres = addres, addresPlus = addresPlus)
            SettingService(this).tryPatchSetting(settingRequest)
        }
    }

    // 서버 연결 성공
    override fun onPatchSettingSuccess(response: SettingResponse) {

        // 계정이 있는 경우
        if(response.isSuccess){
            // 메인 화면으로 이동
            viewBinding.textView.text= "성공!"
        }

        // Result message
        response.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }

    // 서버 연결 실패
    override fun onPatchSettingFailure(message: String) {
        Toast.makeText(this, "오류 : $message", Toast.LENGTH_SHORT).show()
    }
}