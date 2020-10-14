package com.shop.domain.offers
import com.shop.domain.Product
/**
 * Created by Tridev on 10/12/2020.
 */
class BuyOneGetOne:OfferCalculation {
    override fun applyOffer(product:Product, quantity:Int):Double {
        val discountPrice:Double
        if (quantity < 1) return 0.0
        if ((quantity % 2) == 0)
        {
            discountPrice = (quantity / 2) * product.getPrice()
        }
        else
        {
            discountPrice = (Math.floor((quantity / 2).toDouble()) + 1) * product.getPrice()
        }
        return discountPrice
    }
}