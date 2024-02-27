package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Message(
    val messageId:UUID,
    val createdAt:Long,
    var updatedAt:Long? = null,
    val createdBy:Profile,
    var isStarred:Boolean? = null,
    val message:String
)
