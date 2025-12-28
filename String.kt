package com.tech.lib

fun main(args: Array<String>) {
    var s1 : String  = "HelloWorld"
    var s2 : String = "Kotlin is very funny"

    println(s1+s2)
    println(s1+" "+s2)

    println(s1.length)//returns length of the string
    println(s1.isEmpty())//return true if string length is 0 else false

    println(s1.plus(" Good Morning!!"))//concatenates two strings
    println(s1.plus(s2))

    println(s1.lowercase())//converts string into lower case
    println((s2.uppercase()))//converts string into upper case

    var t : String = "   Andriod   "
    println(s1+" "+t.trim())//removes space from starting and ending

}