package com.example.i.community.talk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.i.Main2Activity
import com.example.i.R
import com.example.i.chat.MessageListFragment
import com.example.i.community.search.NewSearchActivity
import com.example.i.community.review.ReviewActivity
import com.example.i.community.diary.DiaryActivity
import com.example.i.community.diary.DiaryCareActivity
import com.example.i.community.diary.DiaryRainActivity
import com.example.i.databinding.ActivityCommunityInfoBinding
import com.example.i.market.MarketFragment
import com.example.i.mypage.fragment.MypageFragment
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator

class CommunityInfoActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityCommunityInfoBinding
    private var tabTitleArray = arrayOf(
        "정보방",
        "인기글"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityInfoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val viewPager = viewBinding.viewpager
        val tabLayout = viewBinding.tabLayout

        viewPager.adapter = CommunityInfoViewpagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        viewBinding.searchBtn.setOnClickListener {
            val intent = Intent(this, NewSearchActivity::class.java)
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
                    finish()

                }

                R.id.drawer_talking -> {
                    val intent = Intent(this, CommunityTalkActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }

                R.id.drawer_qna -> {
                    val intent = Intent(this, CommunityQnaActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }

                R.id.drawer_info -> {
                    val intent = Intent(this, CommunityInfoActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }

                R.id.drawer_diary -> {
                    val intent = Intent(this, DiaryActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()


                }

                R.id.drawer_care -> {
                    val intent = Intent(this, DiaryCareActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }

                R.id.drawer_rain -> {
                    val intent = Intent(this, DiaryRainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }

                R.id.drawer_review -> {
                    val intent = Intent(this, ReviewActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    finish()

                }
            }
            true
        }

        val buttonWrite = viewBinding.btnWrite
        buttonWrite.setOnClickListener{
            val writeIntent = Intent(this, CommunityWriteActivity::class.java)
            writeIntent.putExtra("cindex", 1)
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