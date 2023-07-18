package com.seungdols.company.proto.sample

import com.seungdols.company.proto.order.vo.Order
import com.seungdols.company.proto.order.vo.Product
import com.seungdols.company.proto.order.vo.order
import com.seungdols.company.proto.order.vo.product
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
    val order = order {
        id = "1"
        customerId = "2"
        totalPrice = 35000
    }

    val products = listOf(
        product {
            id = "1"
            name = "product1"
            quantity = 1
            price = 1000
            productType = Product.ProductType.PRODUCT
        },
        product {
            id = "2"
            name = "product2"
            quantity = 1
            price = 11000
            productType = Product.ProductType.PRODUCT
        },
    )
    val order1 = Order.newBuilder()
        .setId("1")
        .setCustomerId("2")
        .addAllProducts(
            products
        )
        .setTotalPrice(
            products.sumOf { p -> p.price }
        )

    println(order)
    println(order1)
}
