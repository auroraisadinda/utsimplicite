package com.example.mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {

            menuInflater.inflate(R.menu.menu_option, menu)

            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            return when(item.itemId){

                R.id.profile -> {
                    Toast.makeText(this,
                        "Profile Click",
                        Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.setting -> {
                    Toast.makeText(this,
                        "Setting Click",
                        Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.logout -> {
                    Toast.makeText(this,
                        "Logout Click",
                        Toast.LENGTH_SHORT).show()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }

        enableEdgeToEdge()

        //Binding setup
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //EXPLICIT INTENT


        //login
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //register
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        //IMPLICIT INTENT


        //Buka Website
        binding.btnWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }

        //(contoh lokasi)
        binding.btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:-6.2,106.8")
            startActivity(intent)
        }

        //Telepon
        binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:08123456789")
            startActivity(intent)
        }

        // =========================
        // 🔧 HANDLE EDGE TO EDGE
        // =========================
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }
}