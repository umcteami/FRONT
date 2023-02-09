package com.example.i.community.talk

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.UploadPhotoActivity
import com.example.i.community.customdialog.CMCategoryDialog
import com.example.i.databinding.ActivityCommunityWriteBinding
import com.example.i.databinding.DialogComminityWritingBinding

class CommunityWriteActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityCommunityWriteBinding
    private val PICK_IMAGE_REQUEST = 1000
    private var title: String = ""
    private var content: String = ""
    private var category: String = ""
    private var boardId : Int? = null
    private var roomId : Int? = null
    private var userId : Int? = null
    private var imgCnt : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btUpload.setOnClickListener {
            val uploadIntent = Intent(this, CommunityTalkroomActivity::class.java)
            startActivity(uploadIntent)
        }

        viewBinding.btCamera.setOnClickListener {
            val cameraIntent = Intent(this, UploadPhotoActivity::class.java)
            startActivity(cameraIntent)
        }

        viewBinding.btUpload.isEnabled = false

        viewBinding.btChoiceCategory.setOnClickListener(this)

        viewBinding.etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                category = viewBinding.btChoiceCategory.text.toString()

                viewBinding.btUpload.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리")
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        viewBinding.etContent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                title = viewBinding.etTitle.text.toString()
                content = viewBinding.etContent.text.toString()
                category = viewBinding.btChoiceCategory.text.toString()

                viewBinding.btUpload.isEnabled =
                    title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리")

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            viewBinding.btChoiceCategory.id -> {
                val dlg = CMCategoryDialog(this)
                dlg.setOnOkClickedListener { cText ->
                    viewBinding.btChoiceCategory.text = cText
                    title = viewBinding.etTitle.text.toString()
                    content = viewBinding.etContent.text.toString()
                    category = viewBinding.btChoiceCategory.text.toString()

                    viewBinding.btUpload.isEnabled =
                        title.isNotEmpty() && content.isNotEmpty() && category != ("카테고리")
                }
                dlg.show()
            }

        }
    }
}