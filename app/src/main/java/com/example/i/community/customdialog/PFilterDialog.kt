package com.example.i.community.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogPopularFilterBinding

class PFilterDialog(private val context: AppCompatActivity) {

    private lateinit var binding: DialogPopularFilterBinding
    private lateinit var listener: PFilterDialogOKClickListener
    // 부모 액티비티의 context가 들어감
    private val dlg = Dialog(context)
    private var content: String = ""

    fun show(){
        binding = DialogPopularFilterBinding.inflate(context.layoutInflater)

        // 타이틀바 제거
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setContentView(binding.root)
        // 다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.setCancelable(false)

        binding.btHour.setOnClickListener{
            content = binding.btHour.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btToday.setOnClickListener {
            content = binding.btToday.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btWeek.setOnClickListener {
            content = binding.btWeek.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        dlg.show()
    }

    fun setOnOkClickedListener(listener: (String) -> Unit) {
        this.listener = object: PFilterDialogOKClickListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }

    interface PFilterDialogOKClickListener {
        fun onOKClicked(content: String)

    }
}