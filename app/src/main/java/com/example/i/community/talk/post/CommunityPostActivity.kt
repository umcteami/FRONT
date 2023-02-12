package com.example.i.community.talk.post

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.customdialog.CMCategoryDialog
import com.example.i.community.talk.models.talkroom.ViewTalkroomInterface
import com.example.i.community.talk.models.talkroom.ViewTalkroomResponse
import com.example.i.community.talk.models.talkroom.ViewTalkroomService
import com.example.i.databinding.ActivityCommunityPostBinding
import java.io.File

class CommunityPostActivity : AppCompatActivity(){
    private lateinit var viewBinding : ActivityCommunityPostBinding
    private var heartClick : Boolean = false
    private var cntHeart : Int = 0
//    private val memIdx : Int = 0
//    private val boardType : Int = 0
//    private val roomType : Int = 0
//    private val feedIdx : Int = 0
//    private val title : String = ""
//    private val memNick : String = ""
//    private val content : String = ""
//    private val hit : Int = 0
//    private val commentCnt : Int = 0
//    private val time : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCommunityPostBinding.inflate(layoutInflater)




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
////                dlg.setOnOkClickedListener(object : CMCategoryDialog.CategoryDialogOKClickListener{
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

//    override fun onGetViewTalkroomSuccess(response: ViewTalkroomResponse) {
//        if (response.isSuccess){
//            viewBinding.tvTitle.setText()
//        }
//    }
//
//    override fun onGetViewTalkroomFailure(message: String) {
//        Toast.makeText(this, "글 상세보기 오류 : $message", Toast.LENGTH_SHORT).show()
//    }


}