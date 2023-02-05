package com.example.i.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityMarketPostBinding

class MarketPostActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMarketPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMarketPostBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
    }
}