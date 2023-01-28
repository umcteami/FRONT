package com.example.i.market

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.R
import com.example.i.databinding.FragmentMarketBinding
import com.example.i.toolbar.NotiActivity
import com.example.i.toolbar.SearchActivity
import com.google.android.material.tabs.TabLayout

class MarketFragment : Fragment() {
    private lateinit var viewBinding : FragmentMarketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMarketBinding.inflate(layoutInflater)

        viewBinding.marketToolbar.inflateMenu(R.menu.home_toolbar)

        viewBinding.marketToolbar.setOnMenuItemClickListener {
            when (it.itemId) {

                R.id.home_search -> {
                    val intent = Intent(context, SearchActivity::class.java)
                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    startActivity(intent)
                    true
                }
                R.id.home_noti -> {
                    val intent = Intent(context, NotiActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        return viewBinding.root

        viewBinding.tabMarket.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = childFragmentManager.beginTransaction()
                when(tab?.text) {
                    "전체" -> transaction.replace(viewBinding.tabMarketContent.id, MarketMainFragment())
                    "맘마/까까" -> transaction.replace(viewBinding.tabMarketContent.id, SnackFragment())
                    "장난감" -> transaction.replace(viewBinding.tabMarketContent.id, ToyFragment())
                    "영양제/약/간호용품" -> transaction.replace(viewBinding.tabMarketContent.id, SupplementFragment())
                    "기타" -> transaction.replace(viewBinding.tabMarketContent.id, EtcFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        val marketVPAdapter = MarketVPAdapter(requireActivity())
//        viewBinding.vpMarket.adapter = marketVPAdapter
//
//        val tabTitleArray = arrayOf(
//            "전체",
//            "맘마/까까",
//            "장난감",
//            "영양제/약/간호용품",
//            "기타"
//        )
//
//        TabLayoutMediator(viewBinding.tapMarket, viewBinding.vpMarket) { tab, position ->
//            tab.text = tabTitleArray[position]
//        }.attach()
    }
}

