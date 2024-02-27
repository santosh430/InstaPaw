package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class RescuePost(
    val postId: UUID,
    val createdAt:Long,
    val description:String? = null,
    val imagesUrl:List<String>,
    val rescueGoingCount:Float = 0f,
    val rescueGoingUserProfile: List<Profile>? = null,
    val comments:List<Comment>? = null,
    val commentsCount:Float = 0f
)
