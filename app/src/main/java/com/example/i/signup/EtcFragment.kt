package com.example.i.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.i.MainActivity
import com.example.i.config.BaseResponse
import com.example.i.databinding.FragmentEtcBinding
import com.example.i.signup.customdialog.SignupDialog
import com.example.i.signup.models.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

var signUp_birth : String = "" // 전역 변수
var signUp_adresCode : String = ""
var signUp_adres : String = ""
var signUp_adresPlus : String = ""

val file = File("\\Downloads\\profile2.png")
val requestFile = RequestBody.create("application/pdf".toMediaTypeOrNull(), file)
val body = MultipartBody.Part.createFormData("profile", null.toString())

class EtcFragment : Fragment(), PostSignUpInterface {
    private lateinit var viewBinding : FragmentEtcBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEtcBinding.inflate(inflater, container, false)

        // 데이터 전달
        // signUp_birth = viewBinding.etBirth.text.toString()
        signUp_adresCode = viewBinding.tvAdresCode.text.toString()
        signUp_adres = viewBinding.tvAdres.text.toString()
        // signUp_adresPlus = viewBinding.tvAdresPlus.text.toString()

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btEnd1.setOnClickListener{
            val dialog = SignupDialog()
            dialog.show(activity.supportFragmentManager, "Custom Dialog")

            val SignUpRequest = PostSignUpRequest(email = signUp_email, pw = signUp_pw,
                phone = signUp_phone, nick = signUp_nick, intro = signUp_intro, birth = signUp_birth,
                adresCode = signUp_adresCode, adres = signUp_adres, adresPlus = signUp_adresPlus)
            PostSignUpService(this).tryPostSignUp(SignUpRequest)
        }

        viewBinding.btEnd2.setOnClickListener {
            activity.changeFragment(7)
        }

        return viewBinding.root
    }

    // 서버 연결 성공
    override fun onPostSignUpSuccess(response: BaseResponse) {
        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostSignUpFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}