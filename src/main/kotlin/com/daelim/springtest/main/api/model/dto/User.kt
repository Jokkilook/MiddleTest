package com.daelim.springtest.main.api.model.dto

data class User(
    val id:String,
    val email:String,
    val password:String,
    val name:String,
)

data class UserRequest(
    val id:String,
)
