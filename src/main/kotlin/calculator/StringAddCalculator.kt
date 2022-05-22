package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        val value = validateWithConvertZero(text)
        return getValues(value)
            .sumOf { it.toInt() }
    }

    private fun getValues(value: String): List<String> {
        val result = Regex(CUSTOM_DELIMITER).find(value)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }

        return value.split(DEFAULT_DELIMITER.toRegex())
    }

    private fun validateWithConvertZero(text: String?): String {
        if (text.isNullOrEmpty()) {
            return ZERO
        }

        if (text.isBlank()) {
            return ZERO
        }

        return text
    }

    companion object {
        private const val ZERO = "0"
        private const val DEFAULT_DELIMITER = "[,:]"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
