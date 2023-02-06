package com.example.i.signup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.MainActivity
import com.example.i.databinding.FragmentEmailBinding
import com.example.i.signup.models.*

class EmailFragment : Fragment(), PostCodeInterface {
    private lateinit var viewBinding : FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEmailBinding.inflate(inflater, container, false)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity

        viewBinding.btOk.isEnabled = false

        viewBinding.etEmail.addTextChangedListener(object: TextWatcher{
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var email = viewBinding.etEmail.text.toString()

                viewBinding.btOk.isEnabled = email.isNotEmpty()

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
            val auth = viewBinding.etEmail.text.toString()
            val EmailRequest = PostCodeRequest(type = 1, auth = auth)
            PostCodeService(this).tryPostEmail(EmailRequest)

            activity.changeFragment(1)
        }

        return viewBinding.root
    }

    override fun onPostEmailSuccess(response: CodeResponse) {
        viewBinding.btOk.text = response.message
        //response.message!!.let { Toast.makeText(activity, it, Toast.LENGTH_SHORT).show() }
    }

    override fun onPostEmailFailure(message: String) {
        //Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }

    override fun onPostPhoneSuccess(response: CodeResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostPhoneFailure(message: String) {
        TODO("Not yet implemented")
    }
}