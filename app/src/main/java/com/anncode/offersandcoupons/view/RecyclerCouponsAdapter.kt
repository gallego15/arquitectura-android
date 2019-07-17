package com.anncode.offersandcoupons.view

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(var couponViewModel: CouponViewModel,var resource: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    var l: onItemClickListener? = null

    interface onItemClickListener{
        fun onItemClick(coupon: Coupon?, view: View)
    }

    var coupons: List<Coupon>? = null

    fun setCouponList(coupons: List<Coupon>?){
        this.coupons = coupons
    }

    //interface

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        /*var view: View = LayoutInflater.from(p0.context).inflate(resource, p0, false)
        return CardCouponHolder(view)*/

        val layoutInflater = LayoutInflater.from(p0.context)
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, p1, p0, false)
        return CardCouponHolder(viewDataBinding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponViewModel, p1)
    }

    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    inner class CardCouponHolder(viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {
        override fun onClick(v: View?) {
            val context = v?.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupons?.get(adapterPosition))
            context?.startActivity(showPhotoIntent)


            /*override fun onClick(v: View?) {
                if (v != null) {
                    item_click!!.onItemClick(club_item[adapterPosition], v)
                }
            }*/
        }

        private var viewDataBinding: ViewDataBinding? = null

        init {
            this.viewDataBinding = viewDataBinding
            itemView.setOnClickListener(this)
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            viewDataBinding?.setVariable(BR.vm, couponViewModel)
            viewDataBinding?.setVariable(BR.position, position)
            viewDataBinding?.executePendingBindings()
        }
    }

}
