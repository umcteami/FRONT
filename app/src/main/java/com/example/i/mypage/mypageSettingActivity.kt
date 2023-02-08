package com.example.i.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.i.databinding.ActivityMypageSettingBinding
import com.example.i.login.AccountSearchFragment
import com.example.i.login.NewPwFragment
import com.example.i.login.email
import com.example.i.mypage.data.*
import com.example.i.signup.authIdx
import com.example.i.signup.models.GetEmailService
import com.google.gson.annotations.SerializedName


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
//            viewBinding.editBrith.isEnabled = true


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
            val email = viewBinding.editEmail.text.toString()
            val phone = viewBinding.editCall.text.toString()
            val nick = viewBinding.editNickName.text.toString()
            val intro = viewBinding.editIntroduce.text.toString()
            val birth = viewBinding.editBrith.text.toString()
            val addresCode = viewBinding.editAdressNum.text.toString()
            val addres = viewBinding.editAddress.text.toString()
            val addresPlus = viewBinding.editAddress2.text.toString()

            // 회원정보 patch
            val settingRequest = SettingRequest(email = email, phone = phone, nick = nick, intro = intro,
                birth = birth, addresCode = addresCode, addres = addres, addresPlus = addresPlus, profile = "\\image\\202301/1673956976696_git.png")
            SettingService(this).tryPatchSetting(settingRequest)
        }

        // 회원정보 get
        SettingService(this).tryGetUser(30)
        Toast.makeText(this,"불러옴",Toast.LENGTH_SHORT).show()
    }

    // 회원정보 수정 API (서버 연결 성공)
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

    // 회원정보 조회 API
    override fun onGetUserSuccess(response: userSearchgResponse){

        if(response.isSuccess){
            // 메인 화면으로 이동
            viewBinding.editEmail.setText(response.result.email)
            viewBinding.editCall.setText(response.result.phone)
            viewBinding.editNickName.setText(response.result.nick)
            viewBinding.editIntroduce.setText(response.result.intro)
            viewBinding.editBrith.setText(response.result.birth)
            viewBinding.editAdressNum.setText(response.result.addresCode)
            viewBinding.editAddress.setText(response.result.addres)
            viewBinding.editAddress2.setText(response.result.addresPlus)
        }

        // Result message
        response.message?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
    }
    override fun onGetuserFailure(message: String){
        Toast.makeText(this, "오류 : $message", Toast.LENGTH_SHORT).show()
    }
}