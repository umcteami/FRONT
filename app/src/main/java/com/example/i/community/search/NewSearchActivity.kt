package com.example.i.community.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.i.databinding.ActivityNewSearchBinding

class NewSearchActivity : AppCompatActivity(), BestKeywordInterface {
    private lateinit var viewBinding : ActivityNewSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityNewSearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        BestKeywordService(this).tryGetBestKeyword()


        viewBinding.etSearch.setOnEditorActionListener{_, actionId, _->
            if(actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || EditorInfo.IME_ACTION_UNSPECIFIED == actionId)
            {
                searchVar.searchBoard = 0
                searchVar.searchRoom = 0
                val searchTerm = viewBinding.etSearch.text.toString()
                val searchIntent = Intent(this, SearchResultActivity::class.java)
                searchIntent.putExtra("searchTerm", "$searchTerm")
                startActivity(searchIntent)
                finish()
                return@setOnEditorActionListener true
            }
            else{
                Toast.makeText(this, "Search를 잘못 누름", Toast.LENGTH_SHORT).show()
                false
            }

        }

    }

    override fun onGetBestKeywordSuccess(response: BestKeywordResponse) {
        if(response.isSuccess){
            val index : Int = response.result.size - 1
            var bestKeyword :  ArrayList<String> = arrayListOf()
            for(i in 0 .. 6){
                bestKeyword.add("")
            }
            for(i in 0 .. index){
                bestKeyword[i] = response.result[i].keyword.toString()
            }

            if(bestKeyword[0] != ""){
                viewBinding.tvSearch1st.text = bestKeyword[0]
            }else{
                viewBinding.tvSearch1st.visibility = GONE
                viewBinding.ivArrow1st.visibility = GONE
            }
            if(bestKeyword[1] != ""){
                viewBinding.tvSearch2nd.text = bestKeyword[1]
            }else{
                viewBinding.tvSearch2nd.visibility = GONE
                viewBinding.ivArrow2nd.visibility = GONE
            }
            if(bestKeyword[2] != ""){
                viewBinding.tvSearch3rd.text = bestKeyword[2]
            }else{
                viewBinding.tvSearch3rd.visibility = GONE
                viewBinding.ivArrow3rd.visibility = GONE
            }
            if(bestKeyword[3] != ""){
                viewBinding.tvSearch4th.text = bestKeyword[3]
            }else{
                viewBinding.tvSearch4th.visibility = GONE
                viewBinding.ivArrow4th.visibility = GONE
            }
            if(bestKeyword[4] != ""){
                viewBinding.tvSearch5th.text = bestKeyword[4]
            }else{
                viewBinding.tvSearch5th.visibility = GONE
                viewBinding.ivArrow5th.visibility = GONE
            }
            if(bestKeyword[5] != ""){
                viewBinding.tvSearch6th.text = bestKeyword[5]
            }else{
                viewBinding.tvSearch6th.visibility = GONE
                viewBinding.ivArrow6th.visibility = GONE
            }
            if(bestKeyword[6] != ""){
                viewBinding.tvSearch7th.text = bestKeyword[6]
            }else{
                viewBinding.tvSearch7th.visibility = GONE
                viewBinding.ivArrow7th.visibility = GONE
            }
        }
    }

    override fun onGetBestKeywordFailure(message: String) {
        Log.d("error", "인기 검색어 오류: $message")
    }
}