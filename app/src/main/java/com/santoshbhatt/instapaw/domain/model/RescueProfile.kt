package com.santoshbhatt.instapaw.domain.model

data class RescueProfile(
    val chats:List<Chat>,
    val rescuePosts:List<RescuePost>,
    val adoptionPosts:List<AdoptionPost>,
    val followedAdoptionPosts:List<AdoptionPost>,
    val followedRescuePosts:List<RescuePost>,
    val rescueNotifications:List<RescueNotification>,
    val blogs:List<Blog>,
    val communities:List<Community>,
    val settings: Settings
)
