package com.example.i.community.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogSearchBinding

class SearchDialog (private val context : AppCompatActivity){
    private lateinit var binding : DialogSearchBinding
    private lateinit var listener : DialogSearchClickListener

    private val dlg = Dialog(context)
    private var content : String = ""

    fun show(){
        binding = DialogSearchBinding.inflate(context.layoutInflater)
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

        binding.btMkAlert4.setOnClickListener{
            content = binding.btMkAlert4.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMkAlert5.setOnClickListener{
            content = binding.btMkAlert5.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }
        dlg.show()
    }

    interface DialogSearchClickListener{
        fun onOKClicked(content : String)
    }

    fun setOnOkClickedListener(listener : (String) -> Unit){
        this.listener = object : DialogSearchClickListener{
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }
}