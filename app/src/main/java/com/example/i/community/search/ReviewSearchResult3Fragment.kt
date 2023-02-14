package com.example.i.community.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.databinding.FragmentReviewSearchResult3Binding
import com.example.i.market.customdialog.MkFilterDialog

class ReviewSearchResult3Fragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding : FragmentReviewSearchResult3Binding
    private lateinit var search: SearchResultActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentReviewSearchResult3Binding.inflate(layoutInflater)

        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<ReviewSearchItem>()
        itemList.apply{

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