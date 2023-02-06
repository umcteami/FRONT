package com.example.i.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.ActivityAnnounceBinding
import com.example.i.mypage.data.AnncmRVAdapter
import com.example.i.mypage.data.Anncms

class AnnounceActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityAnnounceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAnnounceBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val anncmList : ArrayList<Anncms> = arrayListOf()
        val adapter = AnncmRVAdapter(anncmList)

        viewBinding.anncmRv.adapter = adapter
        viewBinding.anncmRv.layoutManager = LinearLayoutManager(this)

        anncmList.apply {
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐adfjkajdflkadafdasfdsf데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))
            add(Anncms("이게될까요되야할텐데요될까요", "2022.12.30"))


        }

        viewBinding.backBtn.setOnClickListener {
            finish()
        }
    }
}