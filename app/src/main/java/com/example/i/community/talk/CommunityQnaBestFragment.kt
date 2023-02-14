package com.example.i.community.talk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardRoomXItem
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentCommunityQnaBestBinding

class CommunityQnaBestFragment : Fragment(), View.OnClickListener {
    private lateinit var viewBinding: FragmentCommunityQnaBestBinding
    private lateinit var main : CommunityQnaActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityQnaBestBinding.inflate(layoutInflater)
        viewBinding.btSort.setOnClickListener(this)

        val itemList = ArrayList<BoardRoomXItem>()


        viewBinding.rvBoard.layoutManager =
            LinearLayoutManager(context)
        val adapter = CommunityRoomXBoardAdapter(itemList)
        viewBinding.rvBoard.adapter = adapter

        adapter!!.itemClick = object : CommunityRoomXBoardAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
        return viewBinding.root
    }

    override fun onAttach(context : Context){
        super.onAttach(context)
        main = context as CommunityQnaActivity
    }

    override fun onClick(view:View?){
        when(view?.id){
            viewBinding.btSort.id ->{
                val dlg = PFilterDialog(main)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.text = content
                }
                dlg.show()
            }
        }
    }
}