package com.example.i.mypage.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.i.config.BaseResponse
import com.example.i.databinding.FragmentSupportAskBinding
import com.example.i.mypage.SupportActivity
import com.example.i.mypage.customdialog.PopupSendDialog
import com.example.i.mypage.data.*

class SupportAskFragment : Fragment(), AskInterface {

    private lateinit var viewBinding: FragmentSupportAskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSupportAskBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment

        val activity = activity as SupportActivity
        var title: String = ""
        var content: String = ""
        var email: String = ""

        viewBinding.button.isEnabled = false

        viewBinding.etTitle.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.supportContext.text.toString()
                email = viewBinding.editText.text.toString()

                viewBinding.button.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && email.isNotEmpty() && viewBinding.appCompatCheckBox.isChecked == true

                if (viewBinding.button.isEnabled == false) {
                    viewBinding.button.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.button.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.supportContext.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.supportContext.text.toString()
                email = viewBinding.editText.text.toString()

                viewBinding.button.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && email.isNotEmpty() && viewBinding.appCompatCheckBox.isChecked == true

                if (viewBinding.button.isEnabled == false) {
                    viewBinding.button.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.button.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.editText.addTextChangedListener(object: TextWatcher {
            // 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            // 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.supportContext.text.toString()
                email = viewBinding.editText.text.toString()

                viewBinding.button.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && email.isNotEmpty() && viewBinding.appCompatCheckBox.isChecked == true

                if (viewBinding.button.isEnabled == false) {
                    viewBinding.button.setTextColor(Color.rgb(0x6B,0x66,0x66))
                }
                else {
                    viewBinding.button.setTextColor(Color.WHITE)
                }
            }

            // 입력 후
            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.appCompatCheckBox.setOnClickListener {
            title = viewBinding.etTitle.text.toString()
            content = viewBinding.supportContext.text.toString()
            email = viewBinding.editText.text.toString()

            viewBinding.button.isEnabled =
                title.isNotEmpty() && content.isNotEmpty() && email.isNotEmpty() && viewBinding.appCompatCheckBox.isChecked == true

            if (viewBinding.button.isEnabled == false) {
                viewBinding.button.setTextColor(Color.rgb(0x6B,0x66,0x66))
            }
            else {
                viewBinding.button.setTextColor(Color.WHITE)
            }
        }

        viewBinding.button.setOnClickListener {
            val dialog = PopupSendDialog()
            dialog.show(activity.supportFragmentManager, "Custom Dialog")

            // 서버에 값 보냄
            val postRequest = PostAskRequest(title = title, content = content, email = email)
            AskService(this).tryPostAsk(postRequest) // 문의하기 API
        }
        return viewBinding.root
    }

    // 문의하기 API
    override fun onPostAskSuccess(response: BaseResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){
            activity?.let{
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.remove(this)
                    ?.commit()
            }
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onPostAskFailure(message: String) {
        Log.d("error", "오류 : $message")
    }
}