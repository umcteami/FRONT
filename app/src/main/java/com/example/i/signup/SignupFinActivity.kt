package com.example.i.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.chat.MessageActivity
import com.example.i.databinding.ActivitySignupFinBinding

class SignupFinActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySignupFinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignupFinBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btStart.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }
    }
}