package com.example.i.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.databinding.ActivityNotiBinding

class NotiActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotiBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.notiBackBtn.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        val notiList: ArrayList<Noti> = arrayListOf()

        notiList.apply {
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요."))
            add(Noti("이야기방","해피엄마","님이 회원님의 댓글에 답변을 남겼어요." ))

        }

        val notiRVAdapter = NotiRVAdapter(notiList)
        viewBinding.notiRV.adapter = notiRVAdapter
        viewBinding.notiRV.layoutManager = LinearLayoutManager(this)


    }
}