package com.example.i.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.i.MainActivity
import com.example.i.config.ApplicationClass
import com.example.i.databinding.FragmentEtcBinding
import com.example.i.signup.customdialog.SignupDialog
import com.example.i.signup.models.*
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var signUp_birth : String = "22222" // 전역 변수
var signUp_adresCode : String = ""
var signUp_adres : String = ""
var signUp_adresPlus : String = "22222"

class EtcFragment : Fragment(), PostSignUpInterface {
    private lateinit var viewBinding : FragmentEtcBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEtcBinding.inflate(inflater, container, false)

        // 데이터 전달
        signUp_birth = viewBinding.etBirth.text.toString()
        signUp_adresCode = viewBinding.tvAdresCode.text.toString()
        signUp_adres = viewBinding.tvAdres.text.toString()
        signUp_adresPlus = viewBinding.tvAdresPlus.text.toString()

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btEnd1.setOnClickListener{
            val dialog = SignupDialog()
            dialog.show(activity.supportFragmentManager, "Custom Dialog")

//            val SignUpRequest = PostSignUpRequest(email = signUp_email, pw = signUp_pw,
//                phone = signUp_phone, nick = signUp_nick, intro = signUp_intro, birth = signUp_birth,
//                adresCode = signUp_adresCode, adres = signUp_adres, adresPlus = signUp_adresPlus, profile = "/image")

            //SignUpRequest 재정의 - profile 제거
            val SignUpRequest = PostSignUpRequest(email = signUp_email, pw = signUp_pw,
                phone = signUp_phone, nick = signUp_nick, intro = signUp_intro, birth = signUp_birth,
                adresCode = signUp_adresCode, adres = signUp_adres, adresPlus = signUp_adresPlus)

            //Gson으로 묶기
            val service = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
            val requestBody = Gson().toJson(SignUpRequest)
                .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
            val emptyImage = RequestBody.create("image/jpeg".toMediaTypeOrNull(), ByteArray(0))
            val image = MultipartBody.Part.createFormData("profile","profile.jpg",emptyImage)

            val call = service.postJoin(requestBody, image)
            call.enqueue(object : Callback<SignUpResponse>{
                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    (response.body() as SignUpResponse?)?.let{
                        onPostSignUpSuccess(it)
                    }
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    onPostSignUpFailure(t.message?:"통신 오류")
                }
            })
            //
//            PostSignUpService(this).tryPostSignUp(SignUpRequest)
        }

        viewBinding.btEnd2.setOnClickListener {
            activity.changeFragment(7)
        }

        return viewBinding.root
    }

    // 서버 연결 성공
    override fun onPostSignUpSuccess(response: SignUpResponse) {
        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostSignUpFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}