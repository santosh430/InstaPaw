package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class Blog(
    val blogId:UUID,
    val blogTitle:String,
    val blogContent:String,
    val blogImagesUrl:List<String>,
    val createdAt:Long,
    val createdBy:String //Store userName of the User
)
