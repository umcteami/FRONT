package com.example.i.mypage.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.Main2Activity
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentMyDiaryBinding
import com.example.i.login.memIdx
import com.example.i.market.customdialog.MkFilterDialog
import com.example.i.mypage.data.DiaryRVAdapter
import com.example.i.mypage.data.MyPost
import com.example.i.mypage.data.post.PostInterface
import com.example.i.mypage.data.post.PostResponse
import com.example.i.mypage.data.post.PostService

class MyDiaryFragment : Fragment(), PostInterface, View.OnClickListener {
    private lateinit var viewBinding: FragmentMyDiaryBinding
    private lateinit var main: Main2Activity

    val DiaryList: ArrayList<MyPost> = arrayListOf()
    val adapter = DiaryRVAdapter(DiaryList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMyDiaryBinding.inflate(layoutInflater)

        viewBinding.btSort.setOnClickListener(this)

        PostService(this).tryGetDiary(memIdx, 0) // 일기장 작성 글 조회 API
        backFragment() // 뒤로가기

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter!!.itemClick = object : DiaryRVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // 일기장 작성 글 조회 API
    override fun onGetDiarySuccess(response: PostResponse) {
        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            DiaryList.apply{
                add(MyPost(response.result[1].toString(), response.result[3].toString(),
                    response.result[8].toString(), response.result[5].toString(), response.result[6].toString()))
            }

            viewBinding.recyclerview.layoutManager = LinearLayoutManager(context)
            viewBinding.recyclerview.adapter = adapter
        }

        // Result message
        Toast.makeText(activity,response.message, Toast.LENGTH_SHORT).show()
    }

    override fun onGetDiaryFailure(message: String) {
        Log.d("error", "오류 : $message")
    }

    override fun onGetPostSuccess(response: PostResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetPostFailure(message: String) {
        TODO("Not yet implemented")
    }


    //뒤로가기
    private fun backFragment() {
        viewBinding.backBtn.setOnClickListener {
            activity?.let{
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.remove(this)
                    ?.commit()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        main = context as Main2Activity
    }

    override fun onClick(view: View?) {
        when (view?.id) {
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