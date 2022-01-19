package com.example.finaldemo.model.got

data class GotResponseItem(
    val members: List<Member>,
    val name: String?,
    val slug: String?
)