package com.example.i

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.i.databinding.FragmentTalkroomBinding


class TalkroomFragment1 : Fragment() {
    private lateinit var binding : FragmentTalkroomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val rv_board = findViewById<RecyclerView>(R.id.rv_board)
        val itemList = ArrayList<BoardItem>()

        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalkroomBinding.inflate(inflater, container, false)
        return binding.root
    }
}