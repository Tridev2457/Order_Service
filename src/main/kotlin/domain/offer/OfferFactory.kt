package com.shop.domain.offers
/**
 * Created by Tridev on 10/12/2020.
 */
class OfferFactory(offer:Offers) {
    private var offer: Offers
    val instance:OfferCalculation
        get() {
            var offerObj: OfferCalculation? = null
            when (offer) {
                Offers.BUY_ONE_GET_ONE -> offerObj = BuyOneGetOne()
                Offers.THREE_FOR_TWO -> offerObj = ThreeForTwo()
                Offers.EMPTY_OFFER -> offerObj = EmptyOffer()
            }
            return offerObj
        }
    init{
        this.offer = offer
    }

}