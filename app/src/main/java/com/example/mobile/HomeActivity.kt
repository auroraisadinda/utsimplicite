package com.example.kabarkota

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    // MENAMPILKAN MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.option_menu, menu)
        return true
    }

    // AKSI KETIKA MENU DIKLIK
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.menu_profile) {
            Toast.makeText(this, "Profile Click", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.menu_setting) {
            Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.menu_logout) {
            Toast.makeText(this, "Logout Click", Toast.LENGTH_SHORT).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}