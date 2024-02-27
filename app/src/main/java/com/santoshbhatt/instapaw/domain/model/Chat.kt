package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Chat(
    val chatId:UUID,
    val createdAt:Long,
    val updatedAt:Long,
    val chatFromProfile: Profile,
    val messages:List<Message>,
    val isBookMarked:Boolean
)
