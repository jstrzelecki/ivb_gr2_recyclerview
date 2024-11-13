package com.example.ivgr2recyclerview

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.File

object SweetsJsonManager {
    private const val FILE_NAME = "seets_data.json"

    fun saveSweetsListToJson(context: Context,
                             sweetsList: List<Sweets>){
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonString = gson.toJson(sweetsList)
        val file = File(context.filesDir, FILE_NAME)
        file.writeText(jsonString)
    }
}