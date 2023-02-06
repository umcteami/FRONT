package com.example.i.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.i.R
import com.example.i.databinding.FragmentCodeCorrectBinding

class CodeCorrectFragment : Fragment() {

    private lateinit var viewBinding: FragmentCodeCorrectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCodeCorrectBinding.inflate(inflater, container, false)

        val activity = activity as AccountSearchActivity

        // 로그인 화면으로 이동
        viewBinding.btOk.setOnClickListener{
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        // 비밀번호 찾기
        viewBinding.btFindPw.setOnClickListener{
            activity.changeFragment(2)
        }
        return viewBinding.root
    }
}