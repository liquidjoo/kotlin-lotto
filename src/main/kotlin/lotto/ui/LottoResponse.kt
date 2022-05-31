package lotto.ui

import lotto.Lotto
import lotto.LottoRank

object LottoResponse {

    private const val RESPONSE_PURCHASE_LOTTO = "%s개를 구매했습니다."
    private const val RESPONSE_STATISTIC_TITLE = "당첨 통계"
    private const val RESPONSE_STATISTIC_BODY = "%s개 일치 (%s원) - %s개"
    private const val RESPONSE_STATISTIC_BODY_WITH_BONUS = "5개 일치, 보너스 볼 일치 (%s원) - %s개"
    private const val RESPONSE_YIELD = "총 수익률은 %s 입니다."
    private const val RESPONSE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    private const val MIN_YIELD = 1

    fun responsePurchase(count: Int) = println(RESPONSE_PURCHASE_LOTTO.format(count))

    fun responseLottos(lottos: List<Lotto>) {
        lottos.forEach { it ->
            val lottoNumbers = it.lotto
                .map { it.number }
                .toString()

            println(lottoNumbers)
        }
    }

    fun responseStatisticTitle() = println(RESPONSE_STATISTIC_TITLE)

    fun responseStatistics(ranks: Map<LottoRank, Int>, result: Double) {
        ranks.entries.forEach {
            if (it.key.isBonus) println(RESPONSE_STATISTIC_BODY_WITH_BONUS.format(it.key.price, it.value))
            else println(RESPONSE_STATISTIC_BODY.format(it.key.matchCount, it.key.price, it.value))
        }

        println(RESPONSE_YIELD.format(result))

        if (result < MIN_YIELD) {
            println(RESPONSE_LOSS)
        }
    }
}