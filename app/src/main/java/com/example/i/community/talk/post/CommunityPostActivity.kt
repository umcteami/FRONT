package com.example.i.community.talk.post

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.i.R
import com.example.i.community.talk.models.talkroom.ViewTalkroomInterface
import com.example.i.community.talk.models.talkroom.ViewTalkroomResponse
import com.example.i.community.talk.models.talkroom.ViewTalkroomService
import com.example.i.databinding.ActivityCommunityPostBinding

class CommunityPostActivity : AppCompatActivity(), ViewTalkroomInterface{

    private lateinit var viewBinding : ActivityCommunityPostBinding
    private var heartClick : Boolean = false
    private var feedIdx = 0
    private var memIdx = 0
    private var cntHeart : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)



        ViewTalkroomService(this).tryGetViewTalkroom(feedIdx,memIdx)

        setContentView(viewBinding.root)

//        setSupportActionBar(viewBinding.toolbar)
        val toolbar = viewBinding.toolbar
        toolbar.inflateMenu(R.menu.mypost_menu)
        toolbar.setOnMenuItemClickListener{item -> onOptionsItemSelected(item)}

        viewBinding.btBack.setOnClickListener {
            finish()
        }

        viewBinding.btnPostHeart.setOnClickListener{
            if(!heartClick){
                heartClick = true
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_press)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() + 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }else{
                heartClick = false
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_normal)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() - 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }
        }

//댓글창
        val commentList : ArrayList<ItemComment> = arrayListOf()
        commentList.apply{
            add(ItemComment("누구엄마","2023.02.10 01:47",null,"하이하이"))
            add(ItemComment("누구엄마","2023.02.10 01:47","별이엄마","하이하이"))
            add(ItemComment("누구엄마","2023.02.10 01:47","별이엄마","하이하이"))
            add(ItemComment("누구엄마","2023.02.10 01:47","별이엄마","하이하이"))
            add(ItemComment("누구엄마","2023.02.10 01:47",null,"하이하이"))
        }
        viewBinding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = PostCommentRVAdapter(commentList)
        viewBinding.rvComment.adapter = adapter

//        adapter!!.menuClick = object : PostCommentRVAdapter.MenuClick{
//            override fun onClick(view: View, position: Int) {
//                val dlg = CMCategoryDialog(this)
//                dlg.show()
//                dlg.setOnOkClickedListener(object : CMCategoryDialog.CategoryDialogOKClickListener{
//                    override fun onOKClicked(content: String) {
//                        return
//                    }
//                })
//            }
//        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mypost_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.post_share -> {
                return true
            }
            R.id.post_edit -> {
                return true
            }
            R.id.post_delete -> {
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onGetViewTalkroomSuccess(response: ViewTalkroomResponse) {
        feedIdx = intent.getIntExtra("storyIdx",2)
        memIdx = intent.getIntExtra("memIdx",33)
//
//        if (response.isSuccess){
////            viewBinding.tvRoomType.text = response.result[memIdx].roomType.toString()
////            viewBinding.tvTitle.text = response.result[memIdx].title
//
//            Glide.with(viewBinding.ivProfileImage)
//                .load(response.result.feed[feedIdx].title)
//                .into(viewBinding.ivProfileImage)
//
//            response.result.feed[feedIdx].roomType.toString() // roomType
//
//            // viewBinding.tvWriter.text = response.result[feedIdx].memNick
//            viewBinding.tvRoomType.text = response.result.feed[feedIdx].roomType.toString() // roomType
//            viewBinding.tvTitle.text = response.result.feed[feedIdx].title.toString() // title
//            viewBinding.tvWriter.text = response.result.feed[feedIdx].memNick.toString() // memNick
//            viewBinding.tvWriteTime.text = response.result.feed[feedIdx].createAt.toString() // createAt
//            viewBinding.tvViewCnt.text = response.result.feed[feedIdx].hit.toString() // hit
//            viewBinding.tvContent.text = response.result.feed[feedIdx].content.toString() // content
//            viewBinding.tvCommentCountNum.text = response.result.feed[feedIdx].commentCnt.toString() // commentCnt

        Log.d("error", "Jerry 오류 : ${response.result.feed}")
        Log.d("error", "Jerry 오류 : ${feedIdx}")
        Log.d("error", "Jerry 오류 : ${memIdx}")

//            Glide.with(viewBinding.ivPost)
//                .load(response.result[feedIdx].img)
//                .into(viewBinding.ivPost)


    }


    override fun onGetViewTalkroomFailure(message: String) {
        Toast.makeText(this, "Jerry 오류 : $message", Toast.LENGTH_SHORT).show()
        Log.d("error", "Jerry 오류 : $message")
    }


}