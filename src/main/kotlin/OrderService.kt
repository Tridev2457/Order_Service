package com.shop.runner
import com.shop.domain.Product
import com.shop.domain.ProductCheckout
import com.shop.domain.offers.Offers
import java.util.*
/**
 * Created by Tridev on 10/12/2020.
 */
class OrderService {
    private fun setProductStock(productName:String, productQuantity:Int) {
        productStock.put(productName, productQuantity.toDouble())
        println("Product Stock has been updated")
    }
    companion object {
        @JvmStatic fun main(args:Array<String>) {
            printProductStock()
            var productsWithOffers: Map<String, Product>? = null
            val productsWithoutOffers = createProductWithoutOffers()
            val sc = Scanner(System.`in`)
            println("====================================")
            println("Orange has 3 for 2 offer")
            println("Apple has buy one get one")
            println("Do you want to apply these offers Y/N ?")
            val offerRequired = sc.nextLine()
            val product:ProductCheckout
            if (offerRequired.equals("Y", ignoreCase = true))
            {
                productsWithOffers = createProductWithOffers()
                product = ProductCheckout(productsWithOffers)
            }
            else
            {
                product = ProductCheckout(productsWithoutOffers)
            }
            println("Please enter products items comma separated (Apple,Orange,Orange...)")
            val basketInput = sc.nextLine()
            val items = basketInput.split(("[, ]+").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            val basketList = Arrays.asList<String>(*items)
            val totalPrice = product.checkoutCalculation(basketList)
            println("Total price: $" + totalPrice)
        }
        private fun printProductStock() {
            println("Available Stock")
            println("Apples's: " + productStock.get("APPLE"))
            println("Orange's: " + productStock.get("ORANGE"))
            println("")
        }
        /*
     * This function follows builder pattern to build objects.
     * This function makes sure that the objects are built based on the offers.
     * */
        private fun createProductWithOffers():Map<String, Product> {
            val orange = Product("Orange", 0.25, Offers.THREE_FOR_TWO)
            val apple = Product("Apple", 0.60, Offers.BUY_ONE_GET_ONE)
            val productList = HashMap<String, Product>()
            productList.put("Orange", orange)
            productList.put("Apple", apple)
            return productList
        }
        /*
     * This function follows builder pattern to build objects.
     * This function makes sure that the objects are built without any offers.
     * */
        private fun createProductWithoutOffers():Map<String, Product> {
            val orange = Product("Orange", 0.25, Offers.EMPTY_OFFER)
            val apple = Product("Apple", 0.60, Offers.EMPTY_OFFER)
            val productList = HashMap<String, Product>()
            productList.put("Orange", orange)
            productList.put("Apple", apple)
            return productList
        }
        private val productStock = HashMap<String, Double>()
        init{
            productStock.put("APPLE", 10.0)
            productStock.put("ORANGE", 10.0)
        }
    }
}