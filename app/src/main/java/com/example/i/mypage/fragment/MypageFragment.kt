package com.example.i.mypage.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.i.R
import com.example.i.databinding.FragmentMypageBinding
import com.example.i.home.HomeFragment
import com.example.i.login.AccountCodeFragment
import com.example.i.login.CodeCorrectFragment
import com.example.i.mypage.*

class MypageFragment : Fragment() {
    private lateinit var viewBinding: FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMypageBinding.inflate(layoutInflater)

        setUpSetting()
        setUpPost()
        setUpDiary()
        setUpMarket()
        setUpLikeP()
        setUpLikeM()
        setUpReport()
        setUpBlock()
        setUpAnncm()
        setUpSupport()

        return viewBinding.root
    }

    private fun setUpSetting() {
        viewBinding.mypageSettingBtn.setOnClickListener {
            activity?.let {
                val intent = Intent(context, mypageSetting::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
    }

    // 작성한 글
    private fun setUpPost() {
        viewBinding.myPostList.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(viewBinding.frameFragment.id, MypostFragment())
                ?.commit()
        }
    }

    // 일기장
    private fun setUpDiary() {
        viewBinding.myDiaryList.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(viewBinding.frameFragment.id, MyDiaryFragment())
                ?.commit()
        }
    }

    // 나눔장터
    private fun setUpMarket() {
        viewBinding.myMarketList.setOnClickListener {
            val intent = Intent(context, MyMarketActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    private fun setUpLikeP() {
        viewBinding.mypageLikeList.setOnClickListener {
            val intent = Intent(context, LikePostActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    private fun setUpLikeM() {
        viewBinding.mypageMarketList.setOnClickListener {
            val intent = Intent(context, LikeMarketActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    private fun setUpReport() {
        viewBinding.mypageReportList.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(viewBinding.frameFragment.id, ReportFragment())
                ?.commit()
        }

    }

    private fun setUpBlock() {
        viewBinding.mypageBolckList.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(viewBinding.frameFragment.id, BlockedFragment())
                ?.commit()
        }

    }

    private fun setUpAnncm() {
        viewBinding.mypageAnncmTv.setOnClickListener {
            val intent = Intent(context, AnnounceActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    private fun setUpSupport() {
        viewBinding.mypageSupportTv.setOnClickListener {
            val intent = Intent(context, SupportActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }
}





