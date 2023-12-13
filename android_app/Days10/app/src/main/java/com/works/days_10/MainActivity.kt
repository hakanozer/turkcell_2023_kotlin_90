package com.works.days_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import com.works.days_10.models.NoteKey
import com.works.days_10.models.Notes

class MainActivity : AppCompatActivity() {

    lateinit var btnGotoSettings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("lifecycle", "onCreate - 1")
        btnGotoSettings = findViewById(R.id.btnGotoSettings)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.e("FCM", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            // Get new FCM registration token
            task.result.let {
                Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
            }
            // Log and toast
        })

        btnGotoSettings.setOnClickListener {
            val i = Intent(MainActivity@this, Settings::class.java)
            startActivity(i)
        }

        /*
        FirebaseMessaging.getInstance().subscribeToTopic("all")
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val token = it.result
                    //Log.d("token", token)
                    Log.d("TAG", "onCreate: Succcess subscribeToTopicsubscribeToTopic")
                }else {
                    Log.d("TAG", "onCreate: Fail subscribeToTopicsubscribeToTopic")
                }
            }
         */

        val note = Notes("Selin", "Bilirler", "selin@mail.com", "12345")
        // Realtime Database
        val db = FirebaseDatabase.getInstance().getReference("notes")
        /*
        val id = db.push().key
        db.child(id!!).setValue(note).addOnCompleteListener {
            Toast.makeText(this, "Add Success", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Add Problem!", Toast.LENGTH_SHORT).show()
        }
        */

        // Data Select
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    snapshot.children.forEach {
                        it?.let {
                            val gson = Gson()
                            val obj = gson.fromJson(it.value.toString(), Notes::class.java)
                            Log.d("noteVal", it.key!!)
                            Log.d("item", obj.toString())
                        }

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }

    override fun onStart() {
        super.onStart()
        // UI -> Button, ImageView, ListView vb. kullanılmaya hazır
        // Uygulamanın başlangıcında ve tekrar aktif olması durumunda çalışır
        Log.d("lifecycle", "onStart - 2")
    }

    override fun onResume() {
        super.onResume()
        // Uygulamanın başlangıcında ve tekrar aktif olması durumunda çalışır
        Log.d("lifecycle", "onResume - 3")
    }


    override fun onPause() {
        super.onPause()
        // Arka plana alınma aşamasında yada yeni bir activity açıldığında
        Log.d("lifecycle", "onPause - 4")
    }

    override fun onStop() {
        super.onStop()
        // Arka plana alındığında yada finish ile terkedildiğinde
        Log.d("lifecycle", "onStop - 5")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Activity geri dönüşü olmayacak şekilde öldürüldü
        Log.d("lifecycle", "onDestroy - 6")
    }



}