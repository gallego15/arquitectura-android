package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable() {
    /*
     * Esta clase tiene una conexion directa con el repositorio y con el view model
     */

    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    /*
     * Envia al viewmodel
     */
    fun getCoupons(): MutableLiveData<List<Coupon>>{
        return couponRepository.getCoupons()
    }

    /*
     * Obtiene del repositorio
     */
    fun callCoupons(){
        couponRepository.callCouponsAPI()
    }
}