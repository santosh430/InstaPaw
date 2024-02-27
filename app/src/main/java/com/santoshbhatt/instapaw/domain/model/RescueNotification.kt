package com.santoshbhatt.instapaw.domain.model

import java.util.UUID

data class RescueNotification(
    val notificationId:UUID,
    val createdAt:Long,
    val createdBy:Profile,
    val notificationAction:NotificationAction,
    val notificationMessage:String,
    val notificationPost:Post
)
