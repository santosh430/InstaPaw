package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Comment(
    val commentId:UUID,
    val createdAt:Long,
    val createdBy:Profile,
    val likesCount:Int,
    val comment:String,
    val commentsChild:List<Comment>
)
