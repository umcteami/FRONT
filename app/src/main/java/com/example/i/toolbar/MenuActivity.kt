package com.example.i.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}