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

    @GetMapping("/lotto")
    fun getLotto(): ResponseEntity<LottoDto> {
        var resultList = mutableListOf<Array<Int>>()

        for(n:Int in 1..5) {
            val numList = mutableListOf<Int>()
            for (i: Int in 1..45) {
                numList.add(i)
            }
            numList.shuffle()
            var array = arrayOf(numList[0], numList[1], numList[2], numList[3], numList[4], numList[5], numList[6])
            array.sort()
            resultList.add(array)
        }


        var response = LottoDto(numbers = resultList)


        return ResponseEntity.ok().body(response)
    }

}


