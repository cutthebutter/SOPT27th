package com.cutthebutter.sopthw1.Recycler

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cutthebutter.sopthw1.R

class ProfileViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val title: TextView = itemView.findViewById(R.id.profileTitle);
    private val subTitle: TextView = itemView.findViewById(R.id.profileSubTitle);

    fun onBind(data : ProfileData) {
        title.text = data.title
        subTitle.text = data.subTitle
    }

    override fun onClick(v: View?) {
        val intent = Intent(v?.context, DetailActivity::class.java)
        v?.context?.startActivity(intent)
    }


}