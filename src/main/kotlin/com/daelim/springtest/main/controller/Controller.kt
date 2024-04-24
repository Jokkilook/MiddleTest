package com.daelim.springtest.main.controller

import com.daelim.springtest.main.api.model.dto.*
import graphql.Mutable

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

    @PostMapping("/lotto")
    fun uploadNum(
        @RequestBody @Valid intputLotto: LottoDto
    ): ResponseEntity<LottoDto> {
        lottoNumList.add(intputLotto)
        var response = intputLotto

        return ResponseEntity.ok().body(response)
    }
}

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

    @PostMapping("/lotto")
    fun uploadNum(
        @RequestBody @Valid intputLotto: LottoDto
    ): ResponseEntity<LottoDto> {
        lottoNumList.add(intputLotto)
        var response = intputLotto

        return ResponseEntity.ok().body(response)
    }

//    @GetMapping("/lotto/check")
//    fun lottoCheck(): ResponseEntity<List<LottoResultResponseDto>> {
//        //저장된 로또 번호 하나씩 당첨번호에 들어있는 지 확인 한 후 있으면 currentNum에 넣고, 보너스 번호도 확인한 뒤 넣어주기
//        var winningNum = LottoResultRequestDto(numbers = mutableListOf(15,16,17,25,30,31), bonusNumber = 32)
//        var list:List<LottoResultResponseDto>
//        var response:MutableList<LottoResultResponseDto>? = null
//        var index = 1
//
//        lottoNumList.forEach{
//
//            it.numbers.forEach{
//                //var result =LottoResult(it)
//                for (i in it) {
//                    if(winningNum.numbers.contains(i)) {
//                    }
//                }
//            }
//            var resultMember = LottoResultResponseDto(index = index, winningNumbers = winningNum, result = )
//            response?.add(resultMember)
//            index++
//        }
//
//
//        return ResponseEntity.ok().body(response)
//    }
}