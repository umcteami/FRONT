package com.example.i.market.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogMarketFilterBinding

class MkFilterDialog(private val context: AppCompatActivity) {

    private lateinit var binding: DialogMarketFilterBinding
    private lateinit var listener: MkFilterDalogOKClickListener
    // 부모 액티비티의 context가 들어감
    private val dlg = Dialog(context)
    private var content: String = ""

    fun show(){
        binding = DialogMarketFilterBinding.inflate(context.layoutInflater)

        // 타이틀바 제거
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setContentView(binding.root)
        // 다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
//        dlg.setCancelable(false)

        binding.btLast.setOnClickListener{
            content = binding.btLast.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btPpl.setOnClickListener {
            content = binding.btPpl.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        dlg.show()
    }

    fun setOnOkClickedListener(listener: (String) -> Unit) {
        this.listener = object: MkFilterDalogOKClickListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }

    interface MkFilterDalogOKClickListener {
        fun onOKClicked(content: String)

    }
}