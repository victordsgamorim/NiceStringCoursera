val vows = "aeiou".flatMap { listOf(it) }

fun String.isNice(): Boolean {
    if (this.noBaBeBu() && this.containVows()) {
        return true
    } else if (this.noBaBeBu() && this.isNextVowRepeated()) {
        return true
    } else if (this.containVows() && this.isNextVowRepeated()) {
        return true
    } else if (this.noBaBeBu() && this.containVows() && this.isNextVowRepeated()) {
        return true
    }

    return false
}

fun String.isNextVowRepeated(): Boolean {

    val countSimilarChar = this.zipWithNext().count { it.first == it.second }
    if (countSimilarChar >= 1) return true
    return false
}

fun String.containVows(): Boolean {

    val totalVows = this.count { it in vows }

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