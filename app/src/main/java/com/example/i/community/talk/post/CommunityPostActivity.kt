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
import com.example.i.community.BoardItem
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
    val imgList : ArrayList<Img> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)

        var storyIdx = intent.getIntExtra("storyIdx",0)
        memIdx = intent.getIntExtra("memIdx",39)

        ViewTalkroomService(this).tryGetViewTalkroom(storyIdx,memIdx)

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

        // 받아온 정보와 UI 연결
        if(response.isSuccess){

            val index: Int = response.result.feed.size - 1
            val index2: Int = response.result.feed.size - 1

            for (i in 0 ..index) {
                if (response.result.feed.size != 0) {

                    Glide.with(viewBinding.ivProfileImage)
                        .load(response.result.feed[index].title)
                        .into(viewBinding.ivProfileImage)

                    response.result.feed[index].roomType.toString() // roomType


//                    imgList.apply {
//                        add(
//                            response.result2
//                        )
//                    }
//                    viewBinding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//                    val adapter = PostImgRVAdapter(imgList)
//                    viewBinding.rvComment.adapter = adapter



                    viewBinding.tvRoomType.text = response.result.feed[index].roomType.toString() // roomType
                    viewBinding.tvTitle.text = response.result.feed[index].title.toString() // title
                    viewBinding.tvWriter.text = response.result.feed[index].memNick.toString() // memNick
                    viewBinding.tvWriteTime.text = response.result.feed[index].createAt.toString() // createAt
                    viewBinding.tvViewCnt.text = response.result.feed[index].hit.toString() // hit
                    viewBinding.tvContent.text = response.result.feed[index].content.toString() // content
                    viewBinding.tvCommentCountNum.text = response.result.feed[index].commentCnt.toString() // commentCnt
                }
            }
            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
        }
    }


    override fun onGetViewTalkroomFailure(message: String) {
        Toast.makeText(this, "오류 : $message", Toast.LENGTH_SHORT).show()
        Log.d("error", "오류 : $message")
    }
}