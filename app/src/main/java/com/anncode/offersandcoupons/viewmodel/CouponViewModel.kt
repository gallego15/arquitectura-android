package com.anncode.offersandcoupons.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso

class CouponViewModel(application: Application) : AndroidViewModel(application) {

    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons(){
        couponObservable.callCoupons()
    }

    fun getCoupons() : MutableLiveData<List<Coupon>>{
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapater(coupons: List<Coupon>){
        recyclerCouponsAdapter?.setCouponList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter? {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position: Int): Coupon?{
        val coupons: List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }

}