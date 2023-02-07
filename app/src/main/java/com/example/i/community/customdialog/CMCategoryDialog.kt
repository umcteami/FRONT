package com.example.i.community.customdialog

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.DialogDiaryCategoryBinding

class CMCategoryDialog (private val context: AppCompatActivity) {

    private lateinit var binding: DialogDiaryCategoryBinding
    private lateinit var listener: CategoryDialogOKClickListener
    // 부모 액티비티의 context가 들어감
    private val dlg = Dialog(context)
    private var content: String = ""

    fun show(){
        binding = DialogDiaryCategoryBinding.inflate(context.layoutInflater)

        // 타이틀바 제거
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setContentView(binding.root)
        // 다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.setCancelable(false)

        binding.btFree.setOnClickListener{
            content = binding.btFree.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btAsk.setOnClickListener {
            content = binding.btAsk.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        // cancel 버튼 동작
        binding.btInfo.setOnClickListener {
            content = binding.btInfo.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btNurse.setOnClickListener{
            content = binding.btNurse.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btMarket.setOnClickListener{
            content = binding.btMarket.text.toString()
            listener.onOKClicked(content)
            dlg.dismiss()
        }

        binding.btRainbow.setOnClickListener{
            content = binding.btRainbow.text.toString()
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