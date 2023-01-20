package com.example.i.community

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityDiaryBinding

class DiaryActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}