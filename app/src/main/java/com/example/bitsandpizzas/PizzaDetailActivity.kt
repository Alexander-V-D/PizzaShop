package com.example.bitsandpizzas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val pizzaId = intent.getIntExtra("pizzaId", 0)
        val pizzaName = Pizzas.pizzas[pizzaId].nName
        val pizzaText = findViewById<TextView>(R.id.pizza_text)
        pizzaText.text = pizzaName
        val pizzaImageId = Pizzas.pizzas[pizzaId].mImageResourceId
        val pizzaImage = findViewById<ImageView>(R.id.pizza_image)
        pizzaImage.setImageDrawable(ContextCompat.getDrawable(this, pizzaImageId))
        pizzaImage.contentDescription = pizzaName
    }
}