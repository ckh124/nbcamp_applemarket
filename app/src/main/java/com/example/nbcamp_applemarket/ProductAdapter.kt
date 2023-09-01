package com.example.nbcamp_applemarket

import android.app.PendingIntent.getActivity
import android.content.Context
import android.graphics.Rect
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.nbcamp_applemarket.databinding.ListItemBinding

import org.w3c.dom.Text
import java.text.DecimalFormat



//class ProductAdapter(val mItems:MutableList<ProductItem>):
//    RecyclerView.Adapter<ProductAdapter.Holder>() {
//
//
//
//    override fun getCount(): Int {
//        return mItems.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return mItems[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
//
//       var convertView=convertView
//        if(convertView == null) convertView=LayoutInflater.from(parent?.context).inflate(R.layout.list_item,parent,false)
//
//        val item : ProductItem = mItems[position]
//
//        val productImgView = convertView?.findViewById<ImageView>(R.id.product_img)
//        val tv_productName = convertView?.findViewById<TextView>(R.id.product_tv)
//        val tv_loca = convertView?.findViewById<TextView>(R.id.location_tv)
//        val tv_cost = convertView?.findViewById<TextView>(R.id.product_cost)
//
//        productImgView?.clipToOutline = true
//        productImgView?.setImageResource(item.img)
//
//        tv_productName?.text = item.productName
//        tv_loca?.text = item.location
//        val dec = DecimalFormat("#,###")
//        val cost = dec.format(item.productCost)
//
//        tv_cost?.text = cost.toString() + "원"
//
//        return convertView
//    }
//    inner class Holder {
//
//    }
//
//}리스트뷰로 구현

class ProductAdapter(val mItems: MutableList<ProductItem>) : RecyclerView.Adapter<ProductAdapter.Holder>() {

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.Holder {//viewHolder 생성
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }
        holder.imgView.clipToOutline = true
        holder.imgView.setImageResource(mItems[position].img)
        holder.tv_productName.text = mItems[position].productName
        holder.tv_comment.text = mItems[position].countChat.toString()
        holder.tv_loca.text = mItems[position].location
        holder.tv_fav.text = mItems[position].countFav.toString()
        holder.tv_comment.text = mItems[position].countChat.toString()


        val dec = DecimalFormat("#,###")
        val cost = dec.format(mItems[position].productCost)

        holder.tv_cost.text = cost.toString() + "원"

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
       return mItems.size
    }
    inner class Holder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgView = binding.productImg
        val tv_productName = binding.productTv
        val tv_loca = binding.locationTv
        val tv_cost = binding.productCost
        val tv_fav = binding.favCountTv
        val tv_comment = binding.chatCountTv
    }



}
