package com.example.ivgr2recyclerview

data class Sweets( val name: String,
                   var price: Double,
                   var isFavorite: Boolean = false,
                   var addToCarCounter: Int = 0
)
