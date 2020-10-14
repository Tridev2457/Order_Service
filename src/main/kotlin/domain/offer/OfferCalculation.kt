package com.shop.domain.offers
import com.shop.domain.Product
/**
 * Created by Tridev on 10/12/2020.
 */
interface OfferCalculation {
    fun applyOffer(product:Product, quantity:Int):Double
}