package lottery.domain

enum class Rank(val matchCount: Int, val price: Int) {
    FIRST(6, 200_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        fun isInTheRank(count: Int): Boolean {
            return values().filter { it.matchCount == count }.any()
        }

        fun valueOf(matchCount: Int): Rank {
            return values().first { it.matchCount == matchCount }
        }
    }
}