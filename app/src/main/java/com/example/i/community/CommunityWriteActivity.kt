package com.example.i.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityCommunityWrite2Binding

class CommunityWriteActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityCommunityWrite2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWrite2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val buttonUpload = viewBinding.btUpload
        buttonUpload.setOnClickListener{
            val uploadIntent = Intent(this, CommunityTalkroomActivity::class.java)
            startActivity(uploadIntent)
        }
    }
}