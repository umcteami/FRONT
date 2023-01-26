package com.example.i

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.i.chat.ChattingFragment
import com.example.i.databinding.ActivityMain2Binding
import com.example.i.home.HomeFragment
import com.example.i.market.MarketFragment
import com.example.i.mypage.MypageFragment

class Main2Activity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.bottomNavi.run {

            //아이템 선택 이벤트
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navi_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.frameFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
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
                            .replace(viewBinding.frameFragment.id, ChattingFragment())
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

            //초기 설정
            selectedItemId = R.id.navi_home //처음 실행할 때 홈 메뉴 가르킬 수 있도록 함
        }

//        setSupportActionBar(viewBinding.toolbar)
//        //Toolbar에 표시되는 제목의 표시 유무를 설정. false로 해야 custom한 툴바의 이름이 화면에 보인다.
//        supportActionBar?.setDisplayShowTitleEnabled(false)
//        //왼쪽 버튼 사용설정(기본은 뒤로가기)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        //왼쪽 버튼 아이콘 변경
//        supportActionBar!!.setHomeAsUpIndicator(R.drawable.toolbar_menu)
//
//        //drawerBinding.drawerNav.setNavigationItemSelectedListener (this)


    }
//    //item 버튼 메뉴 Toolbar에 집어 넣기
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.home_toolbar, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item?.itemId) {
//            android.R.id.home -> {
//                //햄버거 버튼 눌렀을 떄
//                viewBinding.drawerLayout.openDrawer(GravityCompat.START)
//                return true
//            }
//            R.id.home_search -> {
//                //search 버튼 눌렀을 때
//                val intent = Intent(applicationContext, SearchActivity::class.java)
//                startActivity(intent)
//                return true
//            }
//            R.id.home_noti -> {
//                //noti 버튼 눌렀을 때
//                val intent = Intent(applicationContext, NotiActivity::class.java)
//                startActivity(intent)
//                return true
//            }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        TODO("Not yet implemented")
//    }


}
