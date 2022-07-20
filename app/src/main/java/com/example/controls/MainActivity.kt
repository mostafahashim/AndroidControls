package com.example.controls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.controls.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.swipeMainActivity.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeMainActivity.isRefreshing = false
            }, 5000)
        }

        var recyclerList = listOf<RecyclerViewItemModel>(
            RecyclerViewItemModel(title = "item 1"),
            RecyclerViewItemModel(title = "item 2"),
            RecyclerViewItemModel(title = "item 3"),
            RecyclerViewItemModel(holderType = "holder")
        )

        binding.rvMainActivity.adapter =
            RecyclerAdapter(ArrayList(recyclerList), object : OnRecyclerItemClickListener {
                override fun onRecyclerItemClickListener(position: Int) {

                }
            })
        initViewPager()
    }

    fun initViewPager() {
        var items = ArrayList<String>()
        items.add(getString(R.string.tab) + "1")
        items.add(getString(R.string.tab) + "2")
        binding.viewPagerMainActivity.adapter = TabsPagerAdapter(this, items)
        TabLayoutMediator(
            binding.tabsMainActivity,
            binding.viewPagerMainActivity
        ) { tab, position ->
            tab.text = items[position]
        }.attach()
    }
}