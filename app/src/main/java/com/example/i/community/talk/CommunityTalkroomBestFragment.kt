

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
                            hasImage, //????????? ????????? ??????
                            response.result[i].roomType.toString(), //?????? ????????????(1.?????????, 2.?????????, 3.?????????)
                            response.result[i].title, //??????
                            response.result[i].img, //????????? ?????????
                            response.result[i].memProfile,
                            response.result[i].memNick, //????????? ?????????
                            response.result[i].createAt, //???????????? ??? ??????
                            response.result[i].hit.toString(), //?????????
                            response.result[i].likeCnt.toString(), //?????????
                            response.result[i].commentCnt.toString()//?????????
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
                    //??? ?????? ????????????: ?????? ?????????, ????????? ?????????
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
        Log.d("error", "???????????? ???????????? ????????? ??????: $message")
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