package com.tech.lib


fun main(args: Array<String>) {
    var al = arrayListOf<Int>(1,2,3,4,5)

    //printing
    for (x in al){
        println(x)
    }
    println("Size of ArrayList is ${al.size}")
    //adding elements to ArrayList
    al.add(7)
    al.add(8)
    //printing after adding
    for (x in al){
        println(x)
    }

    println("Size of ArrayList is ${al.size}")
    //removing elements in Arraylist
    al.remove(1)
    al.removeAt(5)
    //printing after removing elements
    for (x in al){
        println(x)
    }

    println("Size of ArrayList is ${al.size}")





}