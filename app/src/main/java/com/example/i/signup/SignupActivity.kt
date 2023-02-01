package com.example.i.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.i.R
import com.example.i.databinding.ActivitySignupBinding
import com.example.i.databinding.DialogNicknameBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.signupFragment.id, EmailFragment())
            .commitAllowingStateLoss()
    }

    fun changeFragment(index: Int) {
        when (index) {
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, EmailCodeFragment())
                    .commitAllowingStateLoss()
            }

            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, PhoneFragment())
                    .commitAllowingStateLoss()
            }

            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, PhoneCodeFragment())
                    .commitAllowingStateLoss()
            }

            4 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, PasswordFragment())
                    .commitAllowingStateLoss()
            }

            5 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, NicknameFragment())
                    .commitAllowingStateLoss()
            }

            6 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(viewBinding.signupFragment.id, EtcFragment())
                    .commitAllowingStateLoss()
            }

            else -> {
                val intent = Intent(this, SignupFinActivity::class.java)
                this.startActivity(intent)
            }
        }
    }
}