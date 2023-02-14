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
import com.example.i.community.models.*
import com.example.i.community.talk.models.talkroom.ViewTalkroomInterface
import com.example.i.community.talk.models.talkroom.ViewTalkroomResponse
import com.example.i.community.talk.models.talkroom.ViewTalkroomService
import com.example.i.databinding.ActivityCommunityPostBinding
import com.example.i.login.memIdx
import java.text.SimpleDateFormat

class CommunityPostActivity : AppCompatActivity(), ViewTalkroomInterface, CommentInterface,
    CommentWriteInterface, LikeChangeInterface {

    private lateinit var viewBinding : ActivityCommunityPostBinding
    private var heartClick : Boolean = false
    private var feedIdx = 0
    private var memIdx = 0
    private var cntHeart : Int = 0

    val commentList : ArrayList<ItemComment> = arrayListOf()
    val adapter = PostCommentRVAdapter(commentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)



        ViewTalkroomService(this).tryGetViewTalkroom(1,39)
        CommentService(this).tryGetComment(1, 39)

        setContentView(viewBinding.root)

//        setSupportActionBar(viewBinding.toolbar)
        val toolbar = viewBinding.toolbar
        toolbar.inflateMenu(R.menu.mypost_menu)
        toolbar.setOnMenuItemClickListener{item -> onOptionsItemSelected(item)}

        viewBinding.btBack.setOnClickListener {
            finish()
        }

        viewBinding.btnPostHeart.setOnClickListener{
            var body = RequestLikeChange(39,1,39)
            LikeChangeService(this).tryPostLikeChange(body)

            if(!heartClick){
                heartClick = true
                Toast.makeText(this, "게시글에 하트를 눌렀습니다.", Toast.LENGTH_SHORT).show()
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_press)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() + 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }else{
                heartClick = false
                Toast.makeText(this, "게시글에 하트를 취소하였습니다.", Toast.LENGTH_SHORT).show()
                viewBinding.ivHeart.setImageResource(R.drawable.ic_post_heart_normal)
                cntHeart = viewBinding.tvHeartCnt.text.toString().toInt() - 1
                viewBinding.tvHeartCnt.text = cntHeart.toString()
            }

        }

        viewBinding.btSend.setOnClickListener {
            var body = RequestCommentWrite(1,1,1,"댓글을 작성했습니다.",1)
            CommentWriteService(this).tryPostCommentWrite(body)

        }

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
        memIdx = intent.getIntExtra("memIdx",39)
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

    override fun onGetCommentSuccess(response: CommentResponse) {
        if (response.isSuccess) {
            viewBinding.tvCommentCountNum.text = response.result.size.toString()
            var size = response.result.size - 1

            for (i in 0 .. size) {

                val formatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                val date = formatter.parse(response.result[i].time)

                val sdf = SimpleDateFormat("yyyy.MM.dd hh:mm")

                val getTime = sdf.format(date)

                commentList.apply {
                    add(ItemComment(viewBinding.tvWriter.text.toString(), getTime.toString(), response.result[i].nick, response.result[i].comment))
                }
            }

            viewBinding.rvComment.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            viewBinding.rvComment.adapter = adapter

            Log.d("success", "댓글 조회 success")
        }
    }

    override fun onGetCommentFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    override fun onPostCommentWriteSuccess(response: CommentWriteResponse) {
        if(response.isSuccess) {
            Log.d("success", "댓글 작성 success")
            sendComment()
        }
    }

    override fun onPostCommentWriteFailure(message: String) {
        Log.d("error", "오류: $message")
    }

    fun sendComment() {
        val date: Long = System.currentTimeMillis()

        // 20xx년 xx월 xx일만 나오게 하는 식
        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

        val getTime = sdf.format(date)

        val comment = viewBinding.etChat.text.toString()

        commentList.apply {
            add(ItemComment(viewBinding.tvWriter.text.toString(),getTime.toString(), "nick",comment))
        }

        adapter.notifyDataSetChanged()

    }

    override fun onPostChangeLikeSuccess(response: LikeChangeResponse) {
        if (response.isSuccess) {
            Log.d("success", "좋아요 여부 변경 $response.isSuccess")
        }
    }

    override fun onPostChangeLikeFailure(message: String) {
        Log.d("error", "오류: $message")
    }
}