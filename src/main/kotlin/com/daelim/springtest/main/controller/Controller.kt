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
    @PostMapping("/user/create")
    fun createUser(
        @RequestBody @Valid userDto: UserDto
    ): ResponseEntity<UserDto> {
        val user = userDto
        userList.add(user)

        return ResponseEntity.ok().body(user)
    }

}


