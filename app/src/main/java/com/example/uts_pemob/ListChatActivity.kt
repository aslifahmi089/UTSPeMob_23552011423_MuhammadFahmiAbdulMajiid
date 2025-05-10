package com.example.uts_pemob

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListChatActivity : AppCompatActivity() {
    private val chats = listOf("Ruben", "Hilmy", "Helmy", "Fahmi", "Dikta", "Drew Starkey")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chat)

        val listView = findViewById<ListView>(R.id.listViewChat)
        val adapter = ArrayAdapter(this, R.layout.list_item_chat, chats)
        listView.adapter = adapter

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
