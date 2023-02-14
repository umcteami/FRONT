package com.example.i.mypage.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.i.databinding.ItemBlockedBinding
import com.example.i.databinding.ItemReportBinding

class ReportRVAdapter(private val ReportList: ArrayList<Report>): RecyclerView.Adapter<ReportRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val viewBinding: ItemReportBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind (Report: Report) {
            viewBinding.reportTag.text = Report.roomType
            Glide.with(viewBinding.reportProfile)
                .load(Report.profile)
                .into(viewBinding.reportProfile)
            viewBinding.reportContent.text = Report.nick
            viewBinding.reportTime.text = Report.createAt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =  ItemReportBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ReportList[position])
    }

    override fun getItemCount(): Int = ReportList.size
}