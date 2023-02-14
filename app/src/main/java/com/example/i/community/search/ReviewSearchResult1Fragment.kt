package com.example.i.community.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentReviewSearchResultBinding
import com.example.i.home.HasImage
import com.example.i.market.Market
import com.example.i.market.MarketPostActivity

class ReviewSearchResult1Fragment : Fragment(), HomeSearchInterface, StorySearchInterface, DiarySearchInterface, ReviewSearchInterface, MarketSearchInterface{
    private lateinit var viewBinding : FragmentReviewSearchResultBinding
    var hasImage : HasImage = HasImage.TRUE
    var searchKeyword : String? = ""
    var category : String? = null
    val searchTarget : String = "title_content"
    val userIdx : Int = 33
    val itemList : ArrayList<ReviewSearchItem> = arrayListOf()
    val itemList2 : ArrayList<ReviewSearchItem2> = arrayListOf()
    val mkList : ArrayList<Market> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //게시판 전역 변수
        var categoryGlobal : Int = searchVar.searchBoard
        //방 전역 변수
        var roomGlobal : Int = searchVar.searchRoom
        searchKeyword = searchVar.searchTerm

        when(roomGlobal){
            0 -> when(categoryGlobal){
            }
            1 -> when(categoryGlobal){
                0 -> category = null
                1 -> category = "justchat"
                2 -> category = "question"
                3 -> category = "info"
            }
            2 -> when(categoryGlobal){
                0 -> category = null
                1 -> category = "nurse"
                2 -> category = "rainbow"
            }
            3 -> when(categoryGlobal){
                0 -> category = null
            }
            4 -> when(categoryGlobal){
                0 -> category = null
                1 -> category = "food"
                2 -> category = "toy"
                3 -> category = "medicine"
                4 -> category = "etc"
                5 -> category = "etc"
            }

        }

        viewBinding = FragmentReviewSearchResultBinding.inflate(layoutInflater)


        when(roomGlobal){
            0 -> HomeSearchService(this, searchKeyword, null, searchTarget).tryGetHomeSearch()
            1 -> StorySearchService(this, category, searchKeyword,null, searchTarget).tryGetStorySearch()
            2 -> DiarySearchService(this,category,searchKeyword,null,searchTarget).tryGetDiarySearch()
            3 -> ReviewSearchService(this, searchKeyword, 0).trygetReviewSearch()
            4 -> MarketSearchService(this, category, searchKeyword, null, searchTarget, userIdx).tryGetMarketSearch()
        }
        return viewBinding.root
    }


    //이야기방 검색
    override fun onGetStorySearchSuccess(response: StorySearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            viewBinding.tvResultCount.text = response.result.size.toString()

            for(i in 0 .. index){
                if(response.result[i].img != null){
                    hasImage = HasImage.TRUE
                }else{
                    hasImage = HasImage.FALSE
                }
                itemList.apply{
                    add(
                        ReviewSearchItem(
                            hasImage,
                            response.result[i].title,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString(),
                            response.result[i].img
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)

        ReviewSearchAdapter(itemList)!!.itemClick = object : ReviewSearchAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(),CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onGetHomeSearchSuccess(response: HomeSearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            viewBinding.tvResultCount.text = response.result.size.toString()

            for(i in 0 .. index){
                if(response.result[i].img != null){
                    hasImage = HasImage.TRUE
                }else
                {
                    hasImage = HasImage.FALSE
                }
                itemList.apply{
                    add(
                        ReviewSearchItem(
                            hasImage,
                            response.result[i].title,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString(),
                            response.result[i].img
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)

        ReviewSearchAdapter(itemList)!!.itemClick = object : ReviewSearchAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(),CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onGetHomeSearchFailure(message: String) {
        Log.d("error", "아이홈 검색 오류: $message")
    }
    override fun onGetStorySearchFailure(message: String) {
        Log.d("error", "이야기방 검색 오류: $message")
    }

    //일기장 검색
    override fun onGetDiarySearchSuccess(response: DiarySearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            viewBinding.tvResultCount.text = response.result.size.toString()

            for(i in 0 .. index){
                if(response.result[i].img != null){
                    hasImage = HasImage.TRUE
                }else
                {
                    hasImage = HasImage.FALSE
                }
                itemList.apply{
                    add(
                        ReviewSearchItem(
                            hasImage,
                            response.result[i].title,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].likeCnt.toString(),
                            response.result[i].commentCnt.toString(),
                            response.result[i].img
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)

        ReviewSearchAdapter(itemList)!!.itemClick = object : ReviewSearchAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(),CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onGetDiarySearchFailure(message: String) {
        Log.d("error", "일기장 검색 오류: $message")
    }

    //장터후기 검색
    override fun onGetReviewSearchSuccess(response: ReviewSearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            viewBinding.tvResultCount.text = response.result.size.toString()

            for(i in 0 .. index){
                if(response.result[i].image != null){
                    hasImage = HasImage.TRUE
                } else{
                    hasImage = HasImage.FALSE
                }
                itemList2.apply{
                    add(
                        ReviewSearchItem2(
                            hasImage,
                            response.result[i].sellerNick,
                            response.result[i].goods,
                            response.result[i].buyerNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].hit.toString(), //원래는 좋아요
                            response.result[i].hit.toString(), //원래는 댓글
                            response.result[i].image
                        )
                    )
                }
            }
            viewBinding.rvBoard.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            viewBinding.rvBoard.adapter = ReviewSearchAdapter2(itemList2)

            ReviewSearchAdapter2(itemList2)!!.itemClick = object : ReviewSearchAdapter2.ItemClick{
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onGetReviewSearchFailure(message: String) {
        Log.d("error", "장터후기 검색 오류: $message")
    }

    //나눔장터 검색
    override fun onGetMarketSearchSuccess(response: MarketSearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            viewBinding.tvResultCount.text = response.result.size.toString()

            for(i in 0 .. index){
//                if(response.result[i].img )
                mkList.apply{
                    add(
                        Market(
                            response.result[i].soldout,
                            response.result[i].title,
                            response.result[i].price,
                            response.result[i].createdAt,
                            response.result[i].hit,
                            response.result[i].likeCount,
                            response.result[i].image
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = MarketSearchAdapter(mkList)

        MarketSearchAdapter(mkList)!!.itemClick = object : MarketSearchAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), MarketPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onGetMarketSearchFailure(message: String) {
        Log.d("error", "나눔장터 검색 오류: $message")
    }
}