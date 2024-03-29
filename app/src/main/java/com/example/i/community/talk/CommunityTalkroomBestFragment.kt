

package com.example.i.community.talk

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.i.R
import com.example.i.community.BoardItem
import com.example.i.community.BoardRoomXItem
import com.example.i.community.talk.CommunityBoardAdapter
import com.example.i.community.talk.CommunityTalkroomActivity
import com.example.i.community.customdialog.PFilterDialog
import com.example.i.community.talk.models.talkroom.PplTalkroomInterface
import com.example.i.community.talk.models.talkroom.PplTalkroomResponse
import com.example.i.community.talk.models.talkroom.PplTalkroomService
import com.example.i.community.talk.post.CommunityPostActivity
import com.example.i.databinding.FragmentCommunityTalkroomBestBinding
import com.example.i.home.HasImage


class CommunityTalkroomBestFragment : Fragment(),PplTalkroomInterface, View.OnClickListener {
    private lateinit var viewBinding: FragmentCommunityTalkroomBestBinding

    val itemList: ArrayList<BoardItem> = arrayListOf()
    var hasImage: HasImage = HasImage.TRUE
    val Tadapter = CommunityBoardAdapter(itemList)

    private lateinit var talk : CommunityTalkroomActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentCommunityTalkroomBestBinding.inflate(layoutInflater)

        PplTalkroomService(this).tryGetPplTalkroom("story",1,0)
        viewBinding.btSort.setOnClickListener(this)

        return viewBinding.root
    }

    override fun onGetPplTalkroomSuccess(response: PplTalkroomResponse) {
        if (response.isSuccess) {  val index: Int = response.result.size - 1

            for (i in 0..index) {

                if (response.result[i].img != null) {
                    hasImage = HasImage.TRUE
                } else {
                    hasImage = HasImage.FALSE
                }


                itemList.apply {
                    add(
                        BoardItem(
                            hasImage, //이미지 있는지 여부
                            response.result[i].roomType.toString(), //세부 카테고리(1.수다방, 2.질문방, 3.정보방)
                            response.result[i].title, //제목
                            response.result[i].img, //게시글 이미지
                            response.result[i].memProfile,
                            response.result[i].memNick, //작성자 닉네임
                            response.result[i].createAt, //작성일자 및 시간
                            response.result[i].hit.toString(), //조회수
                            response.result[i].likeCnt.toString(), //하트수
                            response.result[i].commentCnt.toString()//댓글수
                        )
                    )

                }
            }

            viewBinding.rvBoard.layoutManager =
                LinearLayoutManager(requireActivity())
            viewBinding.rvBoard.adapter = Tadapter

            Tadapter!!.itemClick = object : CommunityBoardAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val intent = Intent(requireActivity(), CommunityPostActivity::class.java)
                    //글 정보 보내주기: 회원 인덱스, 게시글 인덱스
//                    intent.putExtra("storyIdx",response.result[position].feedIdx)
//                    intent.putExtra("memIdx",response.result[position].memIdx)
                    startActivity(intent)
                }
            }

            Toast.makeText(activity, response.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        talk = context as CommunityTalkroomActivity
    }

    override fun onGetPplTalkroomFailure(message: String) {
        Log.d("error", "카테고리 이야기방 인기글 오류: $message")
    }

    override fun onClick(view: View?){
        when(view?.id){
            viewBinding.btSort.id -> {
                val dlg = PFilterDialog(talk)
                dlg.setOnOkClickedListener { content ->
                    viewBinding.btSort.setText(content)

                }
                dlg.show()
            }
        }
    }

}