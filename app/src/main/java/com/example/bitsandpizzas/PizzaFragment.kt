package com.example.bitsandpizzas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PizzaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pizzaRecycler: RecyclerView = inflater.inflate(
            R.layout.fragment_pizza, container, false
        ) as RecyclerView
        val pizzaNames = Array(Pizzas.pizzas.size) { "" }
        for (i in Pizzas.pizzas.indices) {
            pizzaNames[i] = Pizzas.pizzas[i].nName
        }
        val pizzaImages = Array(Pizzas.pizzas.size) { 0 }
        for (i in Pizzas.pizzas.indices) {
            pizzaImages[i] = Pizzas.pizzas[i].mImageResourceId
        }
        val adapter = CaptionedImagesAdapter(pizzaNames, pizzaImages)
        pizzaRecycler.adapter = adapter
        val layoutManger = GridLayoutManager(activity, 2)
        pizzaRecycler.layoutManager = layoutManger
        class Listener: CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, PizzaDetailActivity::class.java)
                intent.putExtra("pizzaId", position)
                activity?.startActivity(intent)
            }
        }
        adapter.setNewListener(Listener())
        return pizzaRecycler
    }
}