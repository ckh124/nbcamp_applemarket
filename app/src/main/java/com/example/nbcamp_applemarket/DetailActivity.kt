@file:Suppress("DEPRECATION")

package com.example.nbcamp_applemarket

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.nbcamp_applemarket.databinding.ItemDetailBinding
import java.text.DecimalFormat

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ItemDetailBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail)

        val product = intent.getParcelableExtra<ProductItem>("productItem")
        binding = ItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.detailImg.setImageResource(product!!.img)
        binding.productName.text  = product.productName
        binding.userLocation.text = product.location
        binding.productDetail.text = product.detail

        val dec = DecimalFormat("#,###")
        val cost = dec.format(product.productCost)
        binding.productCost.text = cost.toString() + "원"
        binding.userName.text = product.user

//        holder.imgView.clipToOutline = true
//        binding.detailImg.setImageResource()
//        holder.imgView.setImageResource(mItems[position].img)
//        holder.tv_productName.text = mItems[position].productName
//        holder.tv_comment.text = mItems[position].countChat.toString()
//        holder.tv_loca.text = mItems[position].location
//        holder.tv_fav.text = mItems[position].countFav.toString()



    }



}