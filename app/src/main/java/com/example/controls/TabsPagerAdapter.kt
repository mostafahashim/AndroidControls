package com.example.controls

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.*

class TabsPagerAdapter(
    fa: FragmentActivity,
    var titles: ArrayList<String>,
) :
    FragmentStateAdapter(fa) {


    override fun getItemCount(): Int = titles.size ?: 0

    override fun createFragment(position: Int): Fragment {
        val b = Bundle()

        var fragment = TapFragment()
        b.putString("position",(position+1).toString())
        fragment.arguments = b
        return fragment

    }

}