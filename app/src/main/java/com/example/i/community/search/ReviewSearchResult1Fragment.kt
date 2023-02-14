package com.example.i.community.search

import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.BoardItem
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentReviewSearchResultBinding
import com.example.i.home.HasImage

class ReviewSearchResult1Fragment : Fragment(), StorySearchInterface, DiarySearchInterface, ReviewSearchInterface, MarketSearchInterface{
    private lateinit var viewBinding : FragmentReviewSearchResultBinding
    var hasImage : HasImage = HasImage.TRUE
    var searchKeyword : String? = ""
    var category : String? = null
    val searchTarget : String = "title"
    val itemList : ArrayList<ReviewSearchItem> = arrayListOf()
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

        when(categoryGlobal){
            0 -> category = null
            1 -> category = "justchat"
            2 -> category ="question"
            3 -> category = "info"
        }
        viewBinding = FragmentReviewSearchResultBinding.inflate(layoutInflater)


        when(roomGlobal){
            1 -> StorySearchService(this, category, searchKeyword,null, searchTarget).tryGetStorySearch()
            2 -> DiarySearchService(this,category,searchKeyword,null,searchTarget).tryGetDiarySearch()


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
                            response.result[i].hit.toString(),
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
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
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
                            response.result[i].hit.toString(),
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
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()    }

    override fun onGetDiarySearchFailure(message: String) {
        Log.d("error", "일기장 검색 오류: $message")
    }

    //장터후기 검색
    override fun onGetReviewSearchSuccess(response: ReviewSearchResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetReviewSearchFailure(message: String) {
        Log.d("error", "장터후기 검색 오류: $message")
    }

    //나눔장터 검색
    override fun onGetMarketSearchSuccess(response: MarketSearchResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetMarketSearchFailure(message: String) {
        Log.d("error", "나눔장터 검색 오류: $message")
    }
}