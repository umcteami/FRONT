package com.example.i.market

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.i.databinding.FragmentMarketMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MarketMainFragment: Fragment() {
    private lateinit var viewBinding: FragmentMarketMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMarketMainBinding.inflate(layoutInflater)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val marketVPAdapter = MarketVPAdapter(requireActivity())
        viewBinding.vpPpl.adapter = marketVPAdapter

        TabLayoutMediator(viewBinding.dotsLayout!!, viewBinding.vpPpl!!){tab, position ->
            viewBinding.vpPpl.setCurrentItem(tab.position)
        }.attach()

        val mkList: ArrayList<Market> = arrayListOf()
        val adapter = MarketRVAdapter(mkList, requireActivity())
        val customDecoration = CustomDecoration(2f, 2f, Color.rgb(0xB4,0xB4,0xB4))

        mkList.apply{
            add(Market("0", "강아지 껌", 30000,"2022-12-23-", 5,6,null))
            add(Market("1", "강아지 껌", 30000,"2022-12-23-", 5,6,null))
        }

        viewBinding.rvMarket.layoutManager = LinearLayoutManager(context)
        viewBinding.rvMarket.adapter = adapter
        viewBinding.rvMarket.addItemDecoration(customDecoration)

        adapter!!.itemClick = object : MarketRVAdapter.ItemClick {

            override fun onClick(view: View, position: Int) {
                val intent = Intent(activity, MarketPostActivity::class.java)
                startActivity(intent)
            }
        }
    }
}