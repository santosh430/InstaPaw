package com.santoshbhatt.instapaw.domain.model

data class Follower(
    val username: String,
    val fullName: String,
    val gender:String,
    val profilePicUrl: String,
    val about: String?,
    val followersCount: Long,
    val followingCount: Long,
    val postCount: Int,
    val posts:List<Post>
)
