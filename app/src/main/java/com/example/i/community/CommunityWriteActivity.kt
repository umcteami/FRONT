package com.example.i.community

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.customdialog.CMCategoryDialog
import com.example.i.community.customdialog.DialogPost
import com.example.i.community.customdialog.TalkroomDialog
import com.example.i.databinding.ActivityCommunityWriteBinding

class CommunityWriteActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewBinding: ActivityCommunityWriteBinding
    private var index: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val buttonUpload = viewBinding.btUpload
        var title: String = ""
        var content: String = ""
        var category: String = ""

        index = intent.getIntExtra("cindex", 1)

        viewBinding.btChoiceCategory.setOnClickListener(this)

        buttonUpload.setOnClickListener{

            title = viewBinding.etTitle.text.toString()
            content = viewBinding.etContent.text.toString()
            category = viewBinding.btChoiceCategory.text.toString()

            if (title.isEmpty() == true) {
                val dialog = DialogPost(1)
                dialog.show(supportFragmentManager, "Custom Dialog")
            }
            else if (category.equals("카테고리 선택") == true) {
                val dialog = DialogPost(2)
                dialog.show(supportFragmentManager, "Custom Dialog")
            }
            else if (content.isEmpty() == true) {
                val dialog = DialogPost(3)
                dialog.show(supportFragmentManager, "Custom Dialog")
            }
            else {
                val uploadIntent = Intent(this, CommunityTalkroomActivity::class.java)
                startActivity(uploadIntent)
                finish()
            }
        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            viewBinding.btChoiceCategory.id -> {
                if (index == 1) {
                    val dlg = TalkroomDialog(this)

                    dlg.setOnOkClickedListener { cText ->
                        viewBinding.btChoiceCategory.text = cText
                    }
                    dlg.show()
                }
                else {
                    val dlg = CMCategoryDialog(this)

                    dlg.setOnOkClickedListener { cText ->
                        viewBinding.btChoiceCategory.text = cText
                    }
                    dlg.show()
                }
            }
        }
    }
}