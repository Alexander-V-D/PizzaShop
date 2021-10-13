package com.example.bitsandpizzas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun onClickDone(view: View) {
        val text = "Your order has been updated"
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById<CoordinatorLayout>(R.id.coordinator),
            text, duration)
        snackbar.setAction("Undo", View.OnClickListener {
                val toast = Toast.makeText(this, "Undone!", Toast.LENGTH_SHORT)
                toast.show()
            }
        )
        snackbar.show()
    }
}