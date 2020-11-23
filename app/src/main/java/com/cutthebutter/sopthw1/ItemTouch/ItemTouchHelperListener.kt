package com.cutthebutter.sopthw1.ItemTouch

interface ItemTouchHelperListener {
    fun onItemMoved(from : Int, to : Int)
    fun onItemSwiped(position : Int)
}