package com.example.i.home.total

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ListItemTtl2Binding
import com.example.i.databinding.ListItemTtlBinding
import com.example.i.home.HasImage
import com.example.i.home.Ttls
import com.example.i.home.total.Const.HASIMAGE
import com.example.i.home.total.Const.NOIMAGE

class TtlRVAdapter(private var ttlList:ArrayList<Ttls>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClick: TtlRVAdapter.ItemClick? = null

    inner class TtlWithImageViewHolder(val viewBinding: ListItemTtlBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(ttls: Ttls) {
            viewBinding.ttlTitle.text = ttls.title //제목
            viewBinding.ttlType.text = ttls.boardType.toString() //이야기방, 일기장, 장터후기
            Glide.with(viewBinding.ttlImg.context)
                .load(ttls.img)
                .into(viewBinding.ttlImg)
            viewBinding.ttlWriter.text = ttls.memNick //글쓴이 닉네임
            viewBinding.ttlDate.text = ttls.createAt //글쓴 날짜 및 시간
            viewBinding.ttlViewNum.text = ttls.hit.toString() //조회수
            viewBinding.ttlHaertNum.text = ttls.likeCnt.toString() //하트수
            viewBinding.tlCommentNum.text = ttls.commentCnt.toString() //댓글수
        }
    }

    inner class TtlWithoutImageViewHolder(val viewBinding2: ListItemTtl2Binding) :
        RecyclerView.ViewHolder(viewBinding2.root) {
        fun bind(ttls: Ttls) {
            viewBinding2.ttlTitle.text = ttls.title
            viewBinding2.ttlType.text = ttls.boardType.toString()
            viewBinding2.ttlWriter.text = ttls.memNick
            viewBinding2.ttlDate.text = ttls.createAt
            viewBinding2.ttlViewNum.text = ttls.hit.toString()
            viewBinding2.ttlHaertNum.text = ttls.likeCnt.toString()
            viewBinding2.tlCommentNum.text = ttls.commentCnt.toString()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (ttlList[position].hasImage == HasImage.TRUE) HASIMAGE else NOIMAGE
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HASIMAGE) {
            val view = ListItemTtlBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            TtlWithImageViewHolder(view)
        } else {
            val view = ListItemTtl2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
            TtlWithoutImageViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HASIMAGE) {
            (holder as TtlWithImageViewHolder).bind(ttlList[position])
        }else {
            (holder as TtlWithoutImageViewHolder).bind(ttlList[position])
        }

        if (itemClick != null) {
            if (ttlList[position].hasImage == HasImage.TRUE) {
                (holder as TtlRVAdapter.TtlWithImageViewHolder).viewBinding!!.itemTtl.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }  else {
                (holder as TtlRVAdapter.TtlWithoutImageViewHolder).viewBinding2!!.itemTtl2.setOnClickListener(
                    View.OnClickListener {
                        itemClick?.onClick(it, position)
                    })
            }
        }
    }

    override fun getItemCount(): Int = ttlList.size
    

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

}

object Const {
    const val HASIMAGE = 0
    const val NOIMAGE = 1
}




