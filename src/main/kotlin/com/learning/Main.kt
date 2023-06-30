package com.learning

data class Learning(var lessonName: String, var teacherName: String)

fun main() {
    var word = "This is my way to learn"

    println("Your message is $word")

    val wordLen = word.length

    // nullable checking

    var bla: String? = null

    // return null if not exist
    val blaLen = bla?.length
    println("bla length is $blaLen")

    var default = bla?.length ?: 0
    println("Length of bla is $default")


    // Exception will be thrown
    try {
        var iKnowWhatAmDoing = bla!!.length
    } catch (e: Exception) {
        println("NPE is thrown")
    }

    exersice()
}

fun exersice() {
    var cardPoints = 7_000

    val cardLevel: String = when(cardPoints) {
        in 0..1000      -> "pearl"
        in 1000..5000   -> "silver"
        in 5000..10000  -> "gold"
        else -> "platinum"
    }

    println("You have $cardPoints point and are at the $cardLevel level.")
}

