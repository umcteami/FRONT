package com.example.i.mypage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.i.databinding.ActivityMypageSettingBinding
import com.example.i.login.NewPwFragment
import com.example.i.login.memIdx
import com.example.i.mypage.customdialog.PopupSaveDialog
import com.example.i.mypage.data.*
import java.text.SimpleDateFormat
import java.util.*

var myProfile : String? = null
var myName : String? = null

class MypageSettingActivity : AppCompatActivity(), SettingInterface {
    private lateinit var viewBinding: ActivityMypageSettingBinding
    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMypageSettingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 툴바 뒤로가기 -> 첫 화면으로 이동
        viewBinding.backBtn.setOnClickListener {
            finish()
        }

        // 생일 : 현재 날짜
        val myFormat = "yyyy-MM-dd" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        viewBinding.editBrith.setText(sdf.format(calendar.time))
        viewBinding.changeBirth.setOnClickListener {
            showDatePicker()
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

        // 회원정보 get
        SettingService(this).tryGetUser(memIdx)
        Toast.makeText(this,"불러옴",Toast.LENGTH_SHORT).show()

        // 회원정보 수정
        viewBinding.mypageSaveChange.setOnClickListener {
            var dialog = PopupSaveDialog()
            dialog.show(supportFragmentManager,"custom dialog")
        }
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

        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            // 프로필
            myProfile = response.result.profile
            myName = response.result.nick

            if(response.result.profile != null)
            {
                // 사용자 프로필
                Glide.with(viewBinding.editProfile)
                    .load(myProfile)
                    .into(viewBinding.editProfile)
            }
            else
            {   // 기본 프로필
                Glide.with(viewBinding.editProfile)
                    .load("https://github.com/umcteami/FRONT/blob/67c9fc8a8b5000bc6c478aad8c84b277caefa718/app/src/main/res/drawable/basic_profile_large.png?raw=true")
                    .into(viewBinding.editProfile)
            }

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

    // 서버에 값 보냄
    fun serverConnect() {
        val email = viewBinding.editEmail.text.toString()
        val phone = viewBinding.editCall.text.toString()
        val nick = viewBinding.editNickName.text.toString()
        val intro = viewBinding.editIntroduce.text.toString()
        val birth = viewBinding.editBrith.text.toString()
        val addresCode = viewBinding.editAdressNum.text.toString()
        val addres = viewBinding.editAddress.text.toString()
        val addresPlus = viewBinding.editAddress2.text.toString()

        val SettingEditRequest = SettingEditRequest(email = email, phone = phone, nick = nick, intro = intro,
            birth = birth, addresCode = addresCode, addres = addres, addresPlus = addresPlus)

        // 회원 정보 수정 API
        SettingService(this).tryPatchSetting(memIdx, SettingEditRequest)

        finish()
    }

    // DatePicker
    fun showDatePicker() {

        viewBinding.editBrith.setText(SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()))

        // 시작일 직접 설정
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "yyyy-MM-dd" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            viewBinding.editBrith.setText(sdf.format(calendar.time))
        }

        // "변경" 클릭 시 달력 팝업
        viewBinding.changeBirth.setOnClickListener {

            Log.d("Clicked", "Interview Date Clicked")

            val dialog = DatePickerDialog(this, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))

            dialog.show()
        }
    }
}
