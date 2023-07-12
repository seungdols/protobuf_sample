package com.seungdols.company.proto.sample

import com.seungdols.compnay.proto.sample.person

fun main(args: Array<String>){

    val person = person {
        name = "seungdols"
        age = 31
        address = "성남시"
    }

    println(person)
}
