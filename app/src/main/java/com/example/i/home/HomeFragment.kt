package com.example.i.home


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.view.GravityCompat

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.*
import com.example.i.community.diary.DiaryActivity
import com.example.i.community.diary.DiaryCareActivity
import com.example.i.community.diary.DiaryRainActivity
import com.example.i.community.review.ReviewActivity
import com.example.i.community.talk.*
import com.example.i.config.ApplicationClass.Companion.sRetrofit
import com.example.i.databinding.FragmentHomeBinding
import com.example.i.home.total.*
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment(), ViewTtlInterface {
    private lateinit var viewBinding: FragmentHomeBinding
    private var searchText : String = ""


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
            when (it.itemId) {
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
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        viewBinding.homeNotiBtn.setOnClickListener {
            val intent = Intent(context, NotiActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }


        //인기글 RV
        val pplList: ArrayList<Ppls> = arrayListOf()
        val Padapter = PplRVAdapter(pplList)

        pplList.apply {

            add(
                Ppls(
                    HasImage.FALSE,
                    "안녕하세요 오늘 처음 가입해서 인사드립니다.",
                    null,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )
            add(
                Ppls(
                    HasImage.TRUE,
                    "고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요 귀여워요 귀여워요 귀여워요.",
                    R.drawable.img_1,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )
            add(
                Ppls(
                    HasImage.FALSE,
                    "안녕하세요 오늘 처음 가입해서 인사드립니다. 안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요",
                    null,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )
            add(
                Ppls(
                    HasImage.TRUE,
                    "고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",
                    R.drawable.img_1,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )
            add(
                Ppls(
                    HasImage.FALSE,
                    "안녕하세요 오늘 처음 가입해서 인사드립니다.",
                    null,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )
            add(
                Ppls(
                    HasImage.TRUE,
                    "고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",
                    R.drawable.img_1,
                    "별이언니",
                    "2022.11.17",
                    "10",
                    "8",
                    "3"
                )
            )

        }

        viewBinding.homePplRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewBinding.homePplRV.adapter = Padapter

        Padapter!!.itemClick = object : PplRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }


         //ttl 리사이클러뷰 연결?
       ViewTtlService(this).tryGetViewTtl()
        viewTtlRV()

//
//        ttlList.apply {
//            add(Ttls(HasImage.FALSE,"안녕하세요 오늘 처음 가입해서 인사드립니다.",null,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.TRUE,"고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",R.drawable.img_1,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.FALSE,"안녕하세요 오늘 처음 가입해서 인사드립니다. 안녕하세요 안녕하세요 안녕하세요 안녕하세요 안녕하세요",null,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.FALSE,"안녕하세요 오늘 처음 가입해서 인사드립니다.",null,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.FALSE,"안녕하세요 오늘 처음 가입해서 인사드립니다.",null,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.TRUE,"고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요 귀여워요 귀여워요.",R.drawable.img_1,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.TRUE,"고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",R.drawable.img_1,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.TRUE,"고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",R.drawable.img_1,"별이언니","2022.11.17","10","8","3"))
//            add(Ttls(HasImage.TRUE,"고양이가 귀엽나요 강아지가 귀엽나요 저는 강아지파지만 동글이 귀여워요.",R.drawable.img_1,"별이언니","2022.11.17","10","8","3"))
//        }


        viewBinding.btnWrite.setOnClickListener {
            val intent = Intent(requireActivity(), CommunityWriteActivity::class.java)
            intent.putExtra("cindex", 2)
            startActivity(intent)
        }


        return viewBinding.root
    }

    private fun viewTtlRV(){
        val ttlList: ArrayList<Ttls> = arrayListOf()
        val Tadapter = TtlRVAdapter(ttlList)

        viewBinding.homeTtlRV.layoutManager = LinearLayoutManager(context)
        viewBinding.homeTtlRV.adapter = Tadapter


        Tadapter!!.itemClick = object: TtlRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onGetViewTtlSuccess(response: ViewTtlResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetViewTtlFailure(message: String) {
        TODO("Not yet implemented")
    }




}
