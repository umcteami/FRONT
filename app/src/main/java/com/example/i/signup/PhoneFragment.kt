package com.example.i.signup


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.MainActivity
import com.example.i.databinding.FragmentPhoneBinding
import com.example.i.signup.models.*

class PhoneFragment : Fragment(), PostCodeInterface {
    private lateinit var viewBinding : FragmentPhoneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPhoneBinding.inflate(layoutInflater)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btOk.isEnabled = false

        viewBinding.etPhone.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var phone = viewBinding.etPhone.text.toString()
                viewBinding.btOk.isEnabled = phone.isNotEmpty()

                if (viewBinding.btOk.isEnabled == false) {
                    viewBinding.btOk.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.btOk.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.btOk.setOnClickListener{
            val auth = viewBinding.etPhone.text.toString()
            val PhoneRequest = PostCodeRequest(type = 2, auth = auth)
            PostCodeService(this).tryPostPhone(PhoneRequest)
            activity.changeFragment(3)
        }

        return viewBinding.root
    }

    override fun onPostEmailSuccess(response: CodeResponse) {
    }

    override fun onPostEmailFailure(message: String) {
    }

    override fun onPostPhoneSuccess(response: CodeResponse) {
        viewBinding.btOk.text = response.message
        //response.message!!.let { Toast.makeText(activity, it, Toast.LENGTH_SHORT).show() }
    }

    override fun onPostPhoneFailure(message: String) {
        //Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }
}