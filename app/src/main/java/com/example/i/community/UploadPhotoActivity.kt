package com.example.i.community

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityUploadPhotoBinding

class UploadPhotoActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityUploadPhotoBinding
    private val IMAGE_PICK_CODE = 1000
    private val CROP_CODE = 1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUploadPhotoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


    }

    private fun pickFromGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivity(intent)
    }


}
