package com.example.i.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.ActivityNotiBinding

class NotiActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotiBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.notiToolbar)
        //Toolbar에 표시되는 제목의 표시 유무를 설정. false로 해야 custom한 툴바의 이름이 화면에 보인다.
        supportActionBar?.setDisplayShowTitleEnabled(true)
        //왼쪽 버튼 사용설정(기본은 뒤로가기)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //왼쪽 버튼 아이콘 변경
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back) 

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

    //뒤로 가기 버튼 활성화
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}