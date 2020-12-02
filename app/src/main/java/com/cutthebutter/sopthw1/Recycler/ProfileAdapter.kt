package com.cutthebutter.sopthw1.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cutthebutter.sopthw1.Data.ProfileData
import com.cutthebutter.sopthw1.ItemTouch.ItemTouchHelperListener
import com.cutthebutter.sopthw1.R

class ProfileAdapter (private val context : Context) : RecyclerView.Adapter<ProfileViewHolder>(),
        ItemTouchHelperListener {
    var data = mutableListOf<ProfileData>()
    var changeViewType = 0

    interface ItemClick
    {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        if(viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        }
        return ProfileViewHolder(view)
    }

    fun setItemViewType(sw : Int) {
        changeViewType = sw
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) : Int{
        return changeViewType
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.onBind(data[position])
        if(itemClick != null)
        {
            holder.itemView.setOnClickListener { v ->
                itemClick?.onClick(v, position)
            }
        }
    }

    override fun onItemMoved(from: Int, to: Int) {
        if (from == to) {
            return
        }

        val fromItem = data.removeAt(from)
        data.add(to, fromItem)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

}