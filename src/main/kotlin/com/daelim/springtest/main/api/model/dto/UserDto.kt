package com.daelim.springtest.main.api.model.dto

data class UserDto(
    val fullName:String,
    val email:String,
    val password:String
)

data class  UserRequestDto(
    val email:String,
    val password:String,
)
