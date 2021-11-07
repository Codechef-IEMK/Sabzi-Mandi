package com.example.ecom

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class ItemAdapter(val itemList: List<Item>, val mActivity:Activity) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    
    val TAG = "Ecom"
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.name.text = currentItem.name
        holder.brand.text = currentItem.brand
        holder.price.text = "Rs. " + currentItem.price.toString()
        holder.size.text = currentItem.sizeInt.toString() + " " + currentItem.unit
        Log.d("Ecom", "onBindViewHolder: "+getImageURL(currentItem.name))
//        Glide.with(mActivity)
//            .load(getImageURL(currentItem.name))
//            .placeholder(R.drawable.placeholder)
//            .listener(object : RequestListener<Drawable>{
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    Log.d(TAG, "onLoadFailed: "+e.toString())
//                    return true
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    Log.d(TAG, "onResourceReady: ")
//                    return true
//                }
//
//            })
//            .dontAnimate()
//            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val brand: TextView = itemView.findViewById(R.id.brand)
        val price: TextView = itemView.findViewById(R.id.price)
        val size: TextView = itemView.findViewById(R.id.size)
        val imageView: ImageView = itemView.findViewById(R.id.image)
    }

    private fun getImageURL(name: String): String {
        var imageUrl : String
        if (name.lowercase().contains("tomato")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/s/40022638_3-fresho-tomato-local-organically-grown.jpg";
        } else if (name.lowercase().contains("onion")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/s/40023472_3-fresho-onion-organically-grown.jpg";
        } else if (name.lowercase().contains("potato")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/s/40023476_4-fresho-potato-organically-grown.jpg";
        } else if (name.lowercase().contains("maggi")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/s/266109_15-maggi-2-minute-instant-noodles-masala.jpg";
        } else if (name.lowercase().contains("aashirvaad atta")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/s/126906_7-aashirvaad-atta-whole-wheat.jpg";
        } else if (name.lowercase().contains("mango")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/l/10000304_4-fresho-mallika-mango.jpg";
        } else if (name.lowercase().contains("banana")) {
            imageUrl =
                "https://www.bigbasket.com/media/uploads/p/l/40179390_6-fresho-baby-banana-robusta.jpg";
        } else {
            imageUrl = "https://www.honestbee.tw/images/placeholder.jpg";
        }
        return imageUrl;
    }


}