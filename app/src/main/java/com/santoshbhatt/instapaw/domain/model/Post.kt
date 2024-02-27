package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Post(
    val postId:UUID,
    val createdAt:Long,
    val description:String? = null,
    val imagesUrl:List<String>,
    val likesCount:Float = 0f,
    val likesUserProfile: List<Profile>? = null,
    val comments:List<Comment>? = null,
    val commentsCount:Float = 0f
)
