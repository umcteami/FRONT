package com.example.i.home


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.databinding.FragmentHomeBinding
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity

@Suppress("UNREACHABLE_CODE")
class HomeFragment :Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
//    private lateinit var viewBinding2: ActivityMain2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
//        viewBinding2 = ActivityMain2Binding.inflate(layoutInflater)

        viewBinding.homeToolbar.inflateMenu(R.menu.home_toolbar)


//        fun clearToolbarMenu() {
//            viewBinding.homeToolbar.menu.clear()
//        }

        viewBinding.homeToolbar.setNavigationIcon(R.drawable.toolbar_menu)

        viewBinding.homeToolbar.setNavigationOnClickListener { view ->
            viewBinding.homeLayout.openDrawer(GravityCompat.START)
            true
        }

        viewBinding.homeToolbar.setOnMenuItemClickListener {
            when (it.itemId) {

                R.id.home_search -> {
                    val intent = Intent(context, SearchActivity::class.java)
                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    true
                }
                R.id.home_noti -> {
                    val intent = Intent(context, NotiActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
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