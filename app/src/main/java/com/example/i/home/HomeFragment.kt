package com.example.i.home


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.*
import com.example.i.databinding.FragmentHomeBinding
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity

@Suppress("UNREACHABLE_CODE")
class HomeFragment :Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)


        viewBinding.homeMenuBtn.setOnClickListener {
            viewBinding.homeLayout.openDrawer(GravityCompat.START)
        }

        viewBinding.drawerView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.drawer_community -> { //이야기방 전체
                    val intent = Intent(context, CommunityTalkroomActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                }

                R.id.drawer_talking -> { //수다방
                    val intent = Intent(context, CommunityTalkActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                }

                R.id.drawer_qna -> { //질문방
                   val intent = Intent(context, CommunityQnaActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                }
                R.id.drawer_info -> { //정보방
                    val intent = Intent(context, CommunityInfoActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                }

                R.id.drawer_diary -> { //일기장 전체
                    val intent = Intent(context, DiaryActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }

                R.id.drawer_care -> { //간호 일기
                    val intent = Intent(context, DiaryCareActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }

                R.id.drawer_care -> { //무지개 일기
                    val intent = Intent(context, DiaryRainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }

                R.id.drawer_review -> {
                    val intent = Intent(context, ReviewActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)

                }
            }
            true
        }



        viewBinding.homeSearchBtn.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.homeNotiBtn.setOnClickListener {
            val intent = Intent(context, NotiActivity::class.java)
            intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }



        //인기글 RV
        val pplList: ArrayList<Ppls> = arrayListOf()
        pplList.apply {
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))
            add(Ppls("안녕하세요. 저는 별이 언니예요","별이언니","23.1.25","32","8","2"))


        }

        viewBinding.homePplRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewBinding.homePplRV.adapter = PplRVAdapter(pplList)

        //전체글 RV

        val ttlList: ArrayList<Ttls> = arrayListOf()

        ttlList.apply {
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
            add(Ttls("안녕하세요. 오늘 처음 가입해서 인사드립니다. 고양이 좋아요","별이언니","23.1.26","2","2","10"))
        }

        viewBinding.homeTtlRV.layoutManager = LinearLayoutManager(context)
        viewBinding.homeTtlRV.adapter = TtlRVAdapter(ttlList)

        return viewBinding.root
    }


}
