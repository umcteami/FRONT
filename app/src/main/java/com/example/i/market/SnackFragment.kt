package com.example.i.market

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.databinding.FragmentSnackBinding
import com.example.i.market.customdialog.MkFilterDialog

class SnackFragment: Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentSnackBinding
    private lateinit var main: Main2Activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSnackBinding.inflate(layoutInflater)

        viewBinding.btSort.setOnClickListener(this)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mkList: ArrayList<Market> = arrayListOf()
        val adapter = MarketRVAdapter(mkList, requireActivity())
        val customDecoration = CustomDecoration(2f, 2f, Color.GRAY)

         mkList.apply{
            add(Market("0", "강아지 껌", 30000,"2022-12-23-", 5,6,null))
            add(Market("1", "강아지 껌", 30000,"2022-12-23-", 5,6,null))
        }

        viewBinding.rvSnack.layoutManager = LinearLayoutManager(context)
        viewBinding.rvSnack.adapter = adapter
        viewBinding.rvSnack.addItemDecoration(customDecoration)

        adapter!!.itemClick = object : MarketRVAdapter.ItemClick {

            override fun onClick(view: View, position: Int) {
                val intent = Intent(activity, MarketPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        main = context as Main2Activity
    }

    override fun onClick(view:View?) {
        when(view?.id) {
            viewBinding.btSort.id -> {
                val dlg = MkFilterDialog(main)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.text = content
                }
                dlg.show()
            }
        }
    }
}