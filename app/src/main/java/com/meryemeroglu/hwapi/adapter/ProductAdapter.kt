package com.meryemeroglu.hwapi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.meryemeroglu.hwapi.R
import com.meryemeroglu.hwapi.databinding.ItemProductBinding
import com.meryemeroglu.hwapi.model.Product
import com.meryemeroglu.hwapi.util.downloadURL

class ProductAdapter(private var productList: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(var view: ItemProductBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemProductBinding>(inflater, R.layout.item_product,parent,false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.view.productTitle.text = productList[position].title
        holder.view.productPrice.text = productList[position].price

        holder.view.productImage.downloadURL(productList[position].image)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Product>){
        productList = newList as ArrayList<Product>
        notifyDataSetChanged()
    }
}