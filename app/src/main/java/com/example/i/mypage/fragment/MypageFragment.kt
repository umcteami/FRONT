package com.example.i.mypage.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.i.Main2Activity
import com.example.i.databinding.FragmentMypageBinding
import com.example.i.login.memIdx
import com.example.i.mypage.*
import com.example.i.mypage.customdialog.PopupEndDialog
import com.example.i.mypage.data.MyPageInterface
import com.example.i.mypage.data.MyPageResponse
import com.example.i.mypage.data.MyPageService

@Suppress("UNREACHABLE_CODE")
class MypageFragment : Fragment(), MyPageInterface {
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
        setUpPolicy()
        setUpRevoke()

        // 마이페이지 시작창 조회 API
        MyPageService(this).tryGetMyPage(memIdx)

        viewBinding.mypageLogoutTv.setOnClickListener {
            //커스텀 다이얼로그 필요(추후에 추가하기)
            val dialog = PopupEndDialog()
            dialog.show((activity as Main2Activity).supportFragmentManager, "custom dialog")
        }

        viewBinding.mypageRevokeTv.setOnClickListener {
            //커스텀 다이얼로그 필요(추후에 추가하기)
            val intent = Intent(activity, RevokeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        return viewBinding.root
    }

    // 마이페이지 시작창 조회 API
    override fun onGetMyPageSuccess(response: MyPageResponse) {

        // 받아온 정보와 UI 연결
        if(response.isSuccess){
            // 프로필
            Glide.with(viewBinding.mypageProfile)
                .load(response.result.profile)
                .into(viewBinding.mypageProfile)

            viewBinding.mypageUsername.text = response.result.nick
            viewBinding.mypageIntro.text = response.result.intro
            viewBinding.mypageMyPostNum.text = response.result.feedCount.toString()
            viewBinding.mypageMyDiaryNum.text = response.result.diaryCount.toString()
            viewBinding.mypageMyMarketNum.text = response.result.marketCount.toString()
        }

        // Result message
        Toast.makeText(activity,response.message,Toast.LENGTH_SHORT).show()
    }

    // 서버 연결 실패
    override fun onGetMyPageFailure(message: String) {
        Toast.makeText(activity, "오류 : $message", Toast.LENGTH_SHORT).show()
    }


    private fun setUpSetting() {
        viewBinding.mypageSettingBtn.setOnClickListener {
            activity?.let {
                val intent = Intent(context, MypageSettingActivity::class.java)
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

    private fun setUpPolicy() {
        viewBinding.mypagePolicyTv.setOnClickListener {
            val intent = Intent(context, PolicyActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    private fun setUpRevoke(){
        viewBinding.mypageRevokeTv.setOnClickListener {
            val intent = Intent(context, RevokeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

}






