package com.shop.domain.offers
import com.shop.domain.Product
/**
 * Created by Tridev on 10/12/2020.
 */
class EmptyOffer:OfferCalculation {
    override fun applyOffer(product:Product, quantity:Int):Double {
        return product.getPrice() * quantity
    }
}