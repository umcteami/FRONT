package com.example.i.community

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.i.community.customdialog.CMCategoryDialog
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

        index = intent.getIntExtra("cindex", 1)

        viewBinding.btChoiceCategory.setOnClickListener(this)

        buttonUpload.setOnClickListener{
            val uploadIntent = Intent(this, CommunityTalkroomActivity::class.java)
            startActivity(uploadIntent)
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