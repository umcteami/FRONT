package com.example.i.signup.customdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.i.databinding.DialogSignupBinding
import com.example.i.signup.SignupActivity

class SignupDialog: DialogFragment() {
    private lateinit var viewBinding: DialogSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogSignupBinding.inflate(inflater, container, false)

        val activity = activity as SignupActivity

        viewBinding.btYes.setOnClickListener {
            activity.changeFragment(7)
            dialog?.dismiss()
        }

        viewBinding.btNo.setOnClickListener {
            dialog?.dismiss()
        }

        return viewBinding.root
    }

}