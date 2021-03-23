package lotto.domain

import java.util.TreeSet

class LottoTicket(val value: TreeSet<LottoNumber>) {

    init {
        checkValidateLottoTicket()
    }

    constructor(numbers: List<Int>) : this(
        TreeSet(
            numbers.map { number ->
                LottoNumber.from(number)
            }
        )
    )

    fun getCountOfMatch(lottoTicket: LottoTicket): Int {
        return lottoTicket.value.count(::isNumberContains)
    }

    fun isNumberContains(lottoNumber: LottoNumber): Boolean {
        return value.contains(lottoNumber)
    }

    private fun checkValidateLottoTicket() {
        require(value.size == LENGTH_OF_LOTTO) { "숫자는 6개가 존재해야 합니다." }
    }

    companion object {
        const val LENGTH_OF_LOTTO = 6
    }
}