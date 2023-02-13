package com.example.i.community

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogPopularFilterBinding

class DialogFilterDate(private val context :AppCompatActivity){
    private lateinit var viewBinding : DialogPopularFilterBinding
    private lateinit var listener: DialogPopularFilterListener

    private val dlg = Dialog(context)
    private var content: String=""

    fun show(){
        viewBinding = DialogPopularFilterBinding.inflate(context.layoutInflater)

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(viewBinding.root)
        //dlg.setCancelable(false)

        viewBinding.btHour.setOnClickListener{
            content = viewBinding.btHour.toString()
            listener.onBtnClicked(content)
            dlg.dismiss()

        }
        viewBinding.btToday.setOnClickListener{
            content = viewBinding.btToday.toString()
            listener.onBtnClicked(content)
            dlg.dismiss()

        }
        viewBinding.btWeek.setOnClickListener{
            content = viewBinding.btWeek.toString()
            listener.onBtnClicked(content)
            dlg.dismiss()

        }
        dlg.show()
    }

    fun setOKClickedListener(listener : (String) -> Unit){
        this.listener = object: DialogPopularFilterListener{
            override fun onBtnClicked(content: String) {
                listener(content)
            }
        }
    }

    interface DialogPopularFilterListener{
        fun onBtnClicked(content : String)
    }
}