package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun `객체생성테스트`() {
        val lottoNumbers = hashSetOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val winningLotto = WinningLotto(lottoNumbers)
        val containsAll = winningLotto.get.containsAll(
            hashSetOf(
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(1),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        assertThat(containsAll).isTrue
    }

    @Test
    fun `유효성 테스트`() {
        val lottoNumbers = hashSetOf(
            LottoNumber(2),
            LottoNumber(3)
        )

        assertThatIllegalArgumentException()
            .isThrownBy { WinningLotto(lottoNumbers) }
    }
}
