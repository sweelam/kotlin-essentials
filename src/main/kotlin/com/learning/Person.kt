package com.learning

class Person(username: String, password: String) {
    constructor(username: String,password: String, age: Long)
    : this(username, password) {
        println("This is second constructor extra field age : $age")
    }
}


fun main() {
    val p = Person("ali", "ali123")
    val p2 = Person("Mayada", "mayad234", 35)
}