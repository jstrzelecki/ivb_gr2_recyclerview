package com.example.ivgr2recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sweetsList = listOf(
            Sweets("krówka", 12.55),
            Sweets("miętus", 2.00),
            Sweets("ekler", 6.50),
            Sweets("beza", 5.59),
            Sweets("lody", 16.00),
        )

        val recyclerView: RecyclerView = findViewById(R.id.sweets_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(sweetsList) { sweet ->
            Toast.makeText(
                this,
                "Wybrałeś: ${sweet.name} za ${sweet.price}",
                Toast.LENGTH_LONG
            ).show()

        }

        val saveButton: Button = findViewById(R.id.save_list_to_json_button)
        saveButton.setOnClickListener {
            try{
                SweetsJsonManager.saveSweetsListToJson(
                    this,
                    sweetsList)
                Toast.makeText(this, "Dane zapisano", Toast.LENGTH_LONG).show()
            }catch(ex: Exception){
                Log.e("save", "Coś poszło nie tak $ex")
            }
        }


    }
}