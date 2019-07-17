package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        setUpBindings(savedInstanceState)


        /*
         * callCoupons
         */

        /*
         * getCoupons
         */

    }

    fun setUpBindings(savedInstanceState: Bundle?){
        val activityMainBinding: com.anncode.offersandcoupons.databinding.ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        activityMainBinding.vm = couponViewModel
        setUpListUpdate()
    }

    fun setUpListUpdate(){
        couponViewModel?.callCoupons()
        couponViewModel?.getCoupons()?.observe(this, Observer {
            couponViewModel?.setCouponsInRecyclerAdapater(it)
        })
    }

}
