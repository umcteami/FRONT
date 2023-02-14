package com.example.i.home


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.diary.DiaryActivity
import com.example.i.community.diary.DiaryCareActivity
import com.example.i.community.diary.DiaryRainActivity
import com.example.i.community.review.ReviewActivity
import com.example.i.community.talk.*
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentHomeBinding
import com.example.i.home.model.*
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity

class HomeFragment :Fragment(), TtlListInterface, PplListInterface {
    private lateinit var viewBinding: FragmentHomeBinding
    private var searchText : String = ""
    val ttlList: ArrayList<Ttls> = arrayListOf()
    val Tadapter = TtlRVAdapter(ttlList)
    var hasImage: HasImage = HasImage.TRUE

    val pplList: ArrayList<Ppls> = arrayListOf()
    val Padapter = PplRVAdapter(pplList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        //인기글 RV

        viewBinding.homePplRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewBinding.homePplRV.adapter = Padapter

        Padapter!!.itemClick = object: PplRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }


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

                R.id.drawer_rain -> { //무지개 일기
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

        viewBinding.btnWrite.setOnClickListener {
            val intent = Intent(requireActivity(), CommunityWriteActivity::class.java)
            intent.putExtra("cindex", 2)
            startActivity(intent)
        }


        //인기글 RV

        //전체글
        TtlListService(this).tryGetTtlList()
        PplListService(this).tryGetPplList()




        return viewBinding.root
    }

    override fun onGetTtlListSuccess(response: TtlListResponse) {
        // 받아온 정보와 UI 연결
        if (response.isSuccess) {

            val index: Int = response.result.size - 1

            for (i in 0 ..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }

                ttlList.apply {
                    add(
                        Ttls(
                            hasImage,
                            response.result[i].boardType.toString(),
                            response.result[i].title,
                            response.result[i].img,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString()
                        )
                    )
                }
            }


        }
        viewBinding.homeTtlRV.layoutManager = LinearLayoutManager(requireActivity())
        viewBinding.homeTtlRV.adapter = Tadapter

        Tadapter!!.itemClick = object: TtlRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                if (response.result[position].roomType == 1){
                    intent.putExtra("storyIdx",response.result[position].feedIdx)
                } else if (response.result[position].roomType == 2){
                    intent.putExtra("diaryIdx",response.result[position].feedIdx)
                } else if (response.result[position].roomType == 3){
                    intent.putExtra("reviewIdx",response.result[position].feedIdx)
                }
                intent.putExtra("memIdx",response.result[position].memIdx)
                startActivity(intent)
            }
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetTtlListFailure(message: String)  {
        Log.d("error","카테고리 전체글 오류: $message")
    }


    override fun onGetPplListSuccess(response: PplListResponse) {
        if(response.isSuccess){
            val index: Int = response.result.size - 1

            for (i in 0 ..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }

                pplList.apply {
                    add(
                        Ppls(
                            hasImage,
                            response.result[i].boardType.toString(),
                            response.result[i].title,
                            response.result[i].img,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString()
                        )
                    )
                }



            }

        }

        viewBinding.homePplRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        viewBinding.homePplRV.adapter = Padapter

        Padapter!!.itemClick = object: PplRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onGetPplListFailure(message: String) {
        Log.d("error","카테고리 전체 인기글 오류: $message")
    }
}
