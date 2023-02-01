package com.example.i.signup

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.i.MainActivity
import com.example.i.databinding.FragmentEmailBinding
import com.example.i.signup.models.*

class EmailFragment : Fragment(), SignUpInterface {
    private lateinit var viewBinding : FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentEmailBinding.inflate(layoutInflater)

        viewBinding.backBtn.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val activity = activity as SignupActivity
        val mContext: Context? = getActivity()

        var message: String = ""

        viewBinding.btOk.isEnabled = false

        viewBinding.etEmail.addTextChangedListener(object: TextWatcher{
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                message = viewBinding.etEmail.text.toString()
                viewBinding.btOk.isEnabled = message.isNotEmpty()

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
            activity.changeFragment(1)
            val auth = viewBinding.etEmail.text.toString()
            val EmailRequest = PostEmailRequest(type = 1, auth = auth)
            SignUpService(this).tryPostEmail(EmailRequest)
        }

        return viewBinding.root
    }

    override fun onPostEmailSuccess(response: EmailResponse) {
        response.message!!.let { Toast.makeText(activity, it, Toast.LENGTH_SHORT).show() }
    }

    override fun onPostEmailFailure(message: String) {
        Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }
}