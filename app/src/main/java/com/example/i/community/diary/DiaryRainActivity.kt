package com.example.i.community.diary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.chat.MessageListFragment
import com.example.i.community.talk.CommunityTalkroomActivity
import com.example.i.community.talk.CommunityWriteActivity
import com.example.i.community.review.ReviewActivity
import com.example.i.databinding.ActivityDiaryRainBinding
import com.example.i.market.MarketFragment
import com.example.i.mypage.fragment.MypageFragment
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity

class DiaryRainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityDiaryRainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDiaryRainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        //툴바 -> 알림
        viewBinding.notiBtn.setOnClickListener {
            val intent = Intent(this, NotiActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        viewBinding.menuBtn.setOnClickListener {
            viewBinding.backLayout.openDrawer(GravityCompat.START)
        }

        //drawer navigation listener
        viewBinding.drawerView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.drawer_community -> {
                    val intent = Intent(this, CommunityTalkroomActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                }
                R.id.drawer_diary -> {
                    val intent = Intent(this, DiaryActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }
                R.id.drawer_review -> {
                    val intent = Intent(this, ReviewActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }
            }
            true
        }

        val buttonWrite = viewBinding.btnWrite
        buttonWrite.setOnClickListener{
            val writeIntent = Intent(this, CommunityWriteActivity::class.java)
            startActivity(writeIntent)
        }

        viewBinding.bottomNavi.run {

            //아이템 선택 이벤트
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navi_home -> {
                        val intent = Intent(context, Main2Activity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(intent)
                    }
                    R.id.navi_market -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.frameFragment.id, MarketFragment())
                            .commitAllowingStateLoss()
                    }

                    R.id.navi_chatting -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.frameFragment.id, MessageListFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.navi_mypage -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.frameFragment.id, MypageFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }

        }
    }
}