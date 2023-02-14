package com.example.i.community

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReviewSearchResultBinding
import com.example.i.market.customdialog.MkFilterDialog

class ReviewSearchResult1Fragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding : FragmentReviewSearchResultBinding
    private lateinit var search: SearchResultActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewSearchResultBinding.inflate(layoutInflater)

        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<ReviewSearchItem>()
        itemList.apply{
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
            add(ReviewSearchItem("별이엄마와 거래해봤어요", "누리엄마", "22.12.12", "조회 12", "5", "2"))
        }
        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvBoard.adapter = ReviewSearchAdapter(itemList)
        return viewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        search = context as SearchResultActivity
    }

    override fun onClick(p0: View?) {
        when(view?.id) {
            viewBinding.btSort.id -> {
                val dlg = MkFilterDialog(search)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.setText(content)
                }
                dlg.show()
            }
        }
    }
}