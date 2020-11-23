package com.cutthebutter.sopthw1.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cutthebutter.sopthw1.R


class bottom_Fragment3 : Fragment() {
    var name = "default"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_3, container, false)
//        val textView = view.findViewById<TextView>(R.id.fragment3)
//        textView.text = name

        return view
    }

}