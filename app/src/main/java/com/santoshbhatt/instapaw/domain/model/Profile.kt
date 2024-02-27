package com.santoshbhatt.instapaw.domain.model

data class Profile(
    val username: String,
    val fullName: String,
    val gender:Gender,
    val profilePicUrl: String,
    val about: String? = null,
    val followersCount: Long = 0,
    val followingCount: Long = 0,
    val postCount: Int = 0,
    val posts:List<Post>? = null,
    val savedPosts:List<Post>? = null,
    val followers:List<Follower>? = null,
    val following:List<Following>? = null
)
