package com.works.days_5

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.view.menu.MenuBuilder

class MainActivity : AppCompatActivity() {

    lateinit var btnAlert: Button
    lateinit var btnPopUp: Button

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPopUp = findViewById(R.id.btnPopUp)
        btnAlert = findViewById(R.id.btnAlert)
        btnAlert.setOnClickListener {
            val builder = AlertDialog.Builder(btnAlert.context)
            builder.setTitle(R.string.alertTitle)
            builder.setMessage(R.string.alertDetail)

            builder.setPositiveButton("Evet", DialogInterface.OnClickListener { dialog, which ->
                Log.d("Evet", "Yes click")
            })

            builder.setNegativeButton("Hayır", DialogInterface.OnClickListener { dialog, which ->
                Log.d("Hayır", "No click")
            })

            builder.setNeutralButton("İptal", DialogInterface.OnClickListener { dialog, which ->
                Log.d("İptal", "Cancel click")
            })

            builder.setCancelable(false)

            val alert = builder.create()
            alert.show()
        }

        btnPopUp.setOnClickListener {
            val popUpMenu = PopupMenu(this, btnPopUp)
            popUpMenu.menuInflater.inflate(R.menu.main, popUpMenu.menu)
            popUpMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.itm_home -> {
                        Log.d("Home", "Home Click")
                        true
                    }
                    R.id.itm_users -> {
                        Log.d("Users", "Users Click")
                        true
                    }
                    R.id.itm_profile -> {
                        Log.d("Profile", "Profile Click")
                        true
                    }
                    else -> false
                }
            }
            popUpMenu.show()
        }
    }


    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val builder = menu as MenuBuilder
        builder.setOptionalIconsVisible(true)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itm_home -> {
                Log.d("Home", "Home Click")
                return true
            }
            R.id.itm_users -> {
                Log.d("Users", "Users Click")
                return true
            }
            R.id.itm_profile -> {
                Log.d("Profile", "Profile Click")
                return true
            }
            else -> false
        }
    }

}