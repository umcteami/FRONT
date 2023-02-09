package com.example.i.community.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.i.community.BoardItem
import com.example.i.databinding.PostListLayoutBinding

class CommunityBoardAdapter(val itemList: ArrayList<BoardItem>) :
RecyclerView.Adapter<CommunityBoardAdapter.BoardViewHolder>(){

    var itemClick: CommunityBoardAdapter.ItemClick? = null

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): BoardViewHolder {
        val viewBinding =
            PostListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(viewBinding)

    }

    override fun onBindViewHolder(holder: CommunityBoardAdapter.BoardViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
//            val fragment = PostFragment()
//            val fragmentManager =
//                (holder.itemView.context as AppCompatActivity).supportFragmentManager
//            fragmentManager.beginTransaction()
//                .replace(R.id.frameFragment, fragment)
//                .addToBackStack(null)
//                .commit()
        }

        if (itemClick != null) {

            holder.viewBinding!!.rootLayout.setOnClickListener(View.OnClickListener {
                itemClick?.onClick(it ,position)
            })
        }
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class BoardViewHolder(val viewBinding: PostListLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root){
        fun bind(item: BoardItem) {
            viewBinding.tvRoominfo.text = item.room
            viewBinding.tvWriter.text = item.writer
            viewBinding.tvWriteTime.text = item.date
            viewBinding.tvView.text = item.view
            viewBinding.tvTitle.text = item.title
            viewBinding.tvHearts.text = item.heart
            viewBinding.tvChat.text = item.comment
        }
    }

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListner = onItemClickListener
    }

    //전달된 객체를 저장할 변수 정의
    private lateinit var itemClickListner: OnItemClickListener

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}