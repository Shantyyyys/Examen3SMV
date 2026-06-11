package com.example.examen3

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvLastConnection = findViewById<TextView>(R.id.tv_last_connection)
        val prefs = getSharedPreferences("examen3_prefs", Context.MODE_PRIVATE)

        // Recuperar última conexión guardada
        val lastConnection = prefs.getString("last_connection", "Sin conexión previa")
        tvLastConnection.text = "Última conexión: $lastConnection"

        // Guardar la conexión actual
        val now = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Date())
        prefs.edit().putString("last_connection", now).apply()
    }
}