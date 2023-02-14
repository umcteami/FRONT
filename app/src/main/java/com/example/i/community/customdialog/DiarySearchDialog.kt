package com.example.i.community.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogDiarySearchBinding
import com.example.i.databinding.DialogSearchBinding

class DiarySearchDialog (private val context : AppCompatActivity){
    private lateinit var binding : DialogDiarySearchBinding
    private lateinit var listener : DialogDiarySearchClickListener

    private val dlg = Dialog(context)
    private var content : String = ""

    fun show(){
        binding = DialogDiarySearchBinding.inflate(context.layoutInflater)
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(binding.root)

        binding.btMkAlert1.setOnClickListener{
            content = binding.btMkAlert1.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMkAlert2.setOnClickListener{
            content = binding.btMkAlert2.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMkAlert3.setOnClickListener{
            content = binding.btMkAlert3.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }
        dlg.show()
    }

    interface DialogDiarySearchClickListener{
        fun onOKClicked(content : String)
    }

    fun setOnOkClickedListener(listener : (String) -> Unit){
        this.listener = object : DialogDiarySearchClickListener{
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }
}