package com.example.i.community

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.chat.MessageListFragment
import com.example.i.databinding.ActivityReviewBinding
import com.example.i.market.MarketFragment
import com.example.i.mypage.MypageFragment
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator

class ReviewActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityReviewBinding
    private val tabTitleArray = arrayOf(
        "장터후기",
        "인기글"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewpager
        val tabLayout = viewBinding.tabLayout

        viewPager.adapter = ReviewViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        //툴바 -> 검색
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

        //툴바 -> drawer navigation open
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
        buttonWrite.setOnClickListener {
            val writeIntent = Intent(this, ReviewWriteActivity::class.java)
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