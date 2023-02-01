package com.example.i.community

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogPopularFilterBinding

class DialogFilterDate(private val context :AppCompatActivity){
    private lateinit var viewBinding : DialogPopularFilterBinding
    private val dlg = Dialog(context)

    fun show(content : String){
        viewBinding = DialogPopularFilterBinding.inflate(context.layoutInflater)

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dlg.setContentView(viewBinding.root)
        dlg.setCancelable(false)

        viewBinding.btHour.setOnClickListener{

        }
        viewBinding.btToday.setOnClickListener{

        }
        viewBinding.btWeek.setOnClickListener{

        }
        dlg.show()
    }
//    fun setOnBtnClickedListener(listener : (String) -> Unit){
//        this.setOnBtnClickedListener = object: DialogPopularFilterListener{
//            override fun onBtnClicked(content: String) {
//                listener(content)
//            }
//        }
//    }

    interface DialogPopularFilterListener{
        fun onBtnClicked(content : String)
    }
}