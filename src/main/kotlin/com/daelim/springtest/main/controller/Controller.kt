package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.*

import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid

import net.datafaker.Faker
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class Controller {
    private val userList = mutableListOf<UserDto>()
    private val lottoNumList = mutableListOf<LottoDto>()

    @PostMapping("/user/login")
    fun login(
        @RequestBody @Valid UserRequestDto:UserRequestDto
    ): ResponseEntity<UserDto> {

        var response:UserDto? = null

        val user = userList.firstOrNull() {it.email==UserRequestDto.email}
        if(user!= null&&user.password==UserRequestDto.password){
            response = user
        }

        return if (response != null) {
            ResponseEntity.ok().body(response)
        } else {
            ResponseEntity.notFound().build()
        }
    }

}


