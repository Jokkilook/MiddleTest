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
//@RequestMapping("/api")
class Controller {
    // 테스트 데이터를 저장할 MutableList
    private val userList = mutableListOf<UserDto>()
    private val lottoNumList = mutableListOf<LottoDto>()
    private val savedNum = mutableListOf<LottoDto>()

    // POST 요청을 처리하는 메소드
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
    @PostMapping("/user/create")
    fun createUser(
        @RequestBody @Valid userDto: UserDto
    ): ResponseEntity<UserDto> {

        val user = userDto

        // 생성된 데이터를 리스트에 추가
        userList.add(user)
        // 생성된 데이터를 응답으로 반환
        return ResponseEntity.ok().body(user)
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

    @GetMapping("/lotto/check")
    fun lottoCheck(): ResponseEntity<List<LottoResultResponseDto>> {
        var winningNum = LottoResultRequestDto(numbers = mutableListOf(15,16,17,25,30,31), bonusNumber = 32)
        var list:List<LottoResultResponseDto>
        lottoNumList.forEach{
            it.numbers.forEach{
                for (i in it) {
                    if(winningNum.numbers.contains(i)){

                    }
                }
            }
        }


        var response = null

        return ResponseEntity.ok().body(response)
    }
}


