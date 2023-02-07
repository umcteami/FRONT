package com.example.i.market.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogMarketCategoryBinding

class CategoryDialog(private val context: AppCompatActivity) {

    private lateinit var binding: DialogMarketCategoryBinding
    private lateinit var listener: CategoryDialogOKClickListener
    // 부모 액티비티의 context가 들어감
    private val dlg = Dialog(context)
    private var content: String = ""

    fun show(){
        binding = DialogMarketCategoryBinding.inflate(context.layoutInflater)

        // 타이틀바 제거
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setContentView(binding.root)
        // 다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.setCancelable(false)

        binding.btMkAlert1.setOnClickListener{
            content = binding.btMkAlert1.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMkAlert2.setOnClickListener {
            content = binding.btMkAlert2.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        // cancel 버튼 동작
        binding.btMkAlert3.setOnClickListener {
            content = binding.btMkAlert3.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMkAlert4.setOnClickListener{
            content = binding.btMkAlert4.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }
        dlg.show()
    }

    fun setOnOkClickedListener(listener: (String) -> Unit) {
        this.listener = object: CategoryDialogOKClickListener {
            override fun onOKClicked(content: String) {
                listener(content)
            }
        }
    }

    interface CategoryDialogOKClickListener {
        fun onOKClicked(content: String)

    }

}