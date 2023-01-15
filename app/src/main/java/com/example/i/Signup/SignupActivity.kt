package com.example.i.Signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.MainActivity
import com.example.i.R
import com.example.i.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySignupBinding
    private var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.signupFragment.id, EmailFragment())
            .commitAllowingStateLoss()


        viewBinding.btOk.setOnClickListener {
            num++
            changeFragment(num)
            viewBinding.btOk.text = "Next$num"
        }
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
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                num = 0
            }
        }
    }

}