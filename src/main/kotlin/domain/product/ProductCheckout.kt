package com.shop.domain
import com.shop.domain.offers.OfferFactory
import java.util.HashMap
/**
 * Created by Tridev on 10/12/2020.
 */
class ProductCheckout(listProduct:Map<String, Product>) {
    private val listProduct:Map<String, Product>
    init{
        this.listProduct = listProduct
    }
    /*
   * This function is responsible to calculate the price.
   * */
    fun checkoutCalculation(basket:List<String>):Double {
        val quantity = HashMap<String, Int>()
        if (basket.isEmpty())
            return 0.0
        for (product in basket)
        {
            quantity.put(product, quantity.getOrDefault(product, 1).plus(1))
        }
        var totalPrice = 0.0
        System.out.println(quantity)
        for (entry in quantity.entries)
        {
            val key = entry.key
            val noOfItem = entry.value
            val price = listProduct.get(key)?.getOfferName()?.let { OfferFactory(it).instance.applyOffer(listProduct.get(key)!!, noOfItem) }
            if (price != null) {
                totalPrice += price
            }
        }
        return totalPrice
    }
}