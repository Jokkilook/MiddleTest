package com.daelim.springtest.main.api.model.dto

data class LottoDto(
    val numbers:MutableList<Array<Int>>,
)

data class LottoResult(
    val numbers:MutableList<Int>,
    val correctNumber:LottoResultRequestDto,
    val result:String
)

data class  LottoResultRequestDto(
    val numbers:MutableList<Int>,
    val bonusNumber:Int,
)

data class LottoResultResponseDto(
    val index:Int,
    val winningNumbers:LottoResultRequestDto,
    val result: LottoResult,
)
