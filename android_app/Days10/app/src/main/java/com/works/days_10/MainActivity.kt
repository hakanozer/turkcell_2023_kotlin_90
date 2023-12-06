package com.works.days_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}