package com.example.bitsandpizzas

class Pizza(name: String, imageResourceId: Int) {
    val nName = name
    val mImageResourceId = imageResourceId
    fun getName() = nName
    fun getImageResourceId() = mImageResourceId
}
object Pizzas {
    val pizzas = listOf(
        Pizza("Diavolo", R.drawable.diavolo),
        Pizza("Funghi",R.drawable.funghi))
}