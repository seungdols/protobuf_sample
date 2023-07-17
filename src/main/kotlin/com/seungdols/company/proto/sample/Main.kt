package com.seungdols.company.proto.sample

import com.seungdols.company.proto.sample.PersonDetailOuterClass.PersonDetail
import com.seungdols.compnay.proto.sample.person

fun main(args: Array<String>) {

    val person = person {
        name = "seungdols"
        age = 31
        address = "성남시"
    }

    println(person)

    val personDetail = personDetail {
        firstName = "choi"
        lastName = "seungdols"
    }

    println(personDetail.firstName) // empty string
    println(personDetail.lastName) // seungdols

    val personDetail2 = PersonDetail.newBuilder()
        .setFirstName("choi")
        .setLastName("seungdols")
        .build();

    println(personDetail2)

}
