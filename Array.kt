package com.tech.lib

fun main(args: Array<String>) {
    var a= arrayOf(1,2,3,4,5)
    //print array element
    println(a[0])
    //printing array elements using get
    println(a.get(0))
    //printing array size
    println(a.size)
    // changing array values using set
    println(a.set(3,3))
    println("-----------------------------")
    //print using for loop
    for (i in a){
        println(i)
    }

    //printing using for loop along with rangeTo() or ".."
    println("-----------------------------")

    for (i in 0..(a.size-1)){
        println("a[$i] = ${a[i]} ")
    }

}

