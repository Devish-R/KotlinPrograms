package com.tech.lib

fun main() {
    var x : Byte = 127
    var y : Short = x.toShort()
    var z : Double = y.toDouble()

    println(x)
    println(y)
    println(z)

    var a : Double = 132.24
    var b : Int = a.toInt()
    var c : Byte = b.toByte()//-124 as it's exceeds the range

    println(a)
    println(b)
    println(c)

}