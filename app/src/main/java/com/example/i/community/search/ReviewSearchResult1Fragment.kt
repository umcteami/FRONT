package com.example.i.community.search

import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.community.BoardItem
import com.example.i.databinding.FragmentReviewSearchResultBinding
import com.example.i.home.HasImage

class ReviewSearchResult1Fragment : Fragment(), StorySearchInterface{
    private lateinit var viewBinding : FragmentReviewSearchResultBinding
    var hasImage : HasImage = HasImage.TRUE
    val itemList : ArrayList<ReviewSearchItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewSearchResultBinding.inflate(layoutInflater)

        StorySearchService(this).tryGetStorySearch()

//        val itemList = ArrayList<ReviewSearchItem>()
//        itemList.apply{
//            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
//            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
//            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
//        }

        return viewBinding.root
    }

    override fun onGetStorySearchSuccess(response: StorySearchResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1

            for(i in 0 .. index){
                if(response.result[i].img != null){
                    hasImage = HasImage.TRUE
                }
                itemList.apply{
                    add(
                        ReviewSearchItem(
//                            var hasImage : HasImage? = null,
//                        val title : String? = null,
//                    val writer : String? = null,
//                    val date : String? = null,
//                    val view : String? = null,
//                    val heart : String? = null,
//                    val comment : String? =null
//                            hasImage,
                            response.result[i].title,
                            response.result[i].memNick,
                            response.result[i].createAt,
                            response.result[i].hit.toString(),
                            response.result[i].hit.toString(),
                            response.result[i].commentCnt.toString()
                        )
                    )
                }
            }
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)
    }

    override fun onGetStorySearchFailure(message: String) {
        Log.d("error", "이야기방 검색 오류: $message")
    }
}