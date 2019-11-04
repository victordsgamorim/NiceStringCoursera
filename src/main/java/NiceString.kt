val vows = "aeiouy".flatMap { listOf(it) }

fun main() {
    val string = "aaa"
    println(string.isNextVowRepeated())
    println(string.containVows())
    println(string.noBaBeBu())

}

fun String.isNextVowRepeated(): Boolean {

    val countSimilarChar = this.zipWithNext().count { it.first in vows && it.first == it.second }

    if (countSimilarChar >= 1) return true
    return false
}

fun String.containVows(): Boolean {
    val countFirstVow = this.zipWithNext().count { it.first in vows }
    val countSecondVow = this.zipWithNext().count { it.second in vows }

    val totalVows = countFirstVow + countSecondVow
    if (totalVows >= 3) return true
    return false
}


fun String.noBaBeBu(): Boolean {
    val words = listOf("ba", "be", "bu")

    for (w in words) {
        when (w) {
            in this -> return false
        }
    }
    return true
}