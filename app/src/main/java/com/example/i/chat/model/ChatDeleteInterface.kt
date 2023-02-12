package com.example.i.chat.model

import com.example.i.config.BaseResponse

interface ChatDeleteInterface {

    fun onPostChatDeleteSuccess(response: BaseResponse)

    fun onPostChatDeleteFailure(message: String)
}