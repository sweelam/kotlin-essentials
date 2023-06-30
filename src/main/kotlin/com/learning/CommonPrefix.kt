fun main() {
    println(
        longestCommonPrefix(arrayOf("flower", "flow", "flight"))
    )

    println(
        longestCommonPrefix(arrayOf("dog","racecar","car"))
    )

    println(
        longestCommonPrefix(arrayOf("dog"))
    )
}


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1)
        return ""

    var result = strs[0]
    for (wordIdx in 1..strs.size - 1) {
        val newWord = strs[wordIdx]
        var charIdx = 0
        while (charIdx < result.length) {
            if (charIdx >= newWord.length || newWord[charIdx] != result[charIdx]) {
                result = result.substring(0, charIdx)
            }
            charIdx++
        }

        if (result.isEmpty()) {
            return ""
        }
    }

    return result
}