package com.shop.domain

import com.shop.domain.offers.Offers

/**
 * Created by Tridev on 10/12/2020.
 */
class Product {

    private lateinit var productName: String
    private var price: Double = 0.toDouble()
    private lateinit var offerName: Offers

    constructor(){}

    constructor(productName: String, price: Double, offerName: Offers) {
        this.productName = productName;
        this.price = price;
        this.offerName = offerName;
    }

    init {
        lateinit var productName: String
        var price: Double
        lateinit var offerName: Offers
    }

    fun getProductName(): String {
        return productName
    }

    fun getPrice(): Double {
        return price
    }

    fun getOfferName(): Offers {
        return offerName
    }

    fun setProductName(productName: String) {
        this.productName = productName
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    fun setOfferName(offerName: Offers) {
        this.offerName = offerName
    }
}