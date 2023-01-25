package com.example.i.Market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
    }
}