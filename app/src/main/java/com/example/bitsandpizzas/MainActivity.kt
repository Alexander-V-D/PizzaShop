package com.example.bitsandpizzas

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var shareActionProvider: ShareActionProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val pagerAdapter = SectionPagerAdapter(supportFragmentManager, resources)
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = pagerAdapter
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
//        val menuItem = menu.findItem(R.id.action_share)
//        shareActionProvider = menuItem.actionProvider
//        setShareActionIntent("want to join me for pizza?")
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_create_order -> {
                val intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra("text", "Want to join me for pizza?")
                startActivity(Intent.createChooser(intent, "Share your order"))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra("text", text)
        shareActionProvider.setShareIntent(intent)
    }
}