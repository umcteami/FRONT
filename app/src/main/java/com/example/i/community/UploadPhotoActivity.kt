package com.example.i.community

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.i.databinding.ActivityUploadPhotoBinding


class UploadPhotoActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityUploadPhotoBinding
//    private val cropImage = registerForActivityResult(CropImageContract()){ result ->
//        if(result.isSuccessful) {
//            val uriContent = result.uriContent
//            val uriFilePath = result.getUriFilePath(this)
//        }else{
//            val exception = result.error
//        }
//    }

//    private fun startCrop(){
//        cropImage.launch(
//            options{
//                setGuidelines(CropImageView.Guidelines.ON)
//            }
//        )
//        cropImage.launch(
//            options {
//                setImagePickerContractOptions(
//                    PickImageContractOptions(includeGallery = true, includeCamera = false)
//                )
//            }
//        )
//
//        // Start cropping activity for pre-acquired image saved on the device and customize settings.
//        cropImage.launch(
//            options(uri = imageUri) {
//                setGuidelines(CropImageView.Guidelines.ON)
//                setOutputCompressFormat(Bitmap.CompressFormat.PNG)
//            }
//        )
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityUploadPhotoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
//
//        viewBinding.btUpload.setOnClickListener{
//            cropImage.launch(
//                options{
//                    setImage
//                }
//            )
//        }
    }

    private fun pickFromGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivity(intent)
    }


}
