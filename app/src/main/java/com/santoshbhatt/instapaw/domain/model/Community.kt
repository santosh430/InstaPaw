package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Community(
    val communityId:UUID,
    val communityName:String,
    val createdAt:Long,
    val createdBy:String,
    val communityAbout:String,
    val chats:List<Chat>,
    val members:List<Profile>,
    val profilePicUrl:String
)
