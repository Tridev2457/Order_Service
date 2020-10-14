package com.shop.domain.offers
import com.shop.domain.Product
/**
 * Created by Tridev on 10/12/2020.
 */
class ThreeForTwo:OfferCalculation {
    override fun applyOffer(product:Product, quantity:Int):Double {
        val discountPrice:Double
        if (quantity < 0)
            return 0.0
        if ((quantity % 3) == 0)
        {
            discountPrice = ((quantity / 3) * 2) * product.getPrice()
        }
        else
        {
            discountPrice = (((quantity / 3) * 2) + 1) * product.getPrice()
        }
        return discountPrice
    }
}