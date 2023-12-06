package com.works.days_10

import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d("XToken", "onNewToken: $token" )
        Toast.makeText(applicationContext, "Token: $token", Toast.LENGTH_SHORT).show()
    }

    override fun onMessageReceived(message: RemoteMessage) {

        Log.d("XMessage", "${message.messageId}")
        Log.d("XMessage", "${message.from}")

        if (message.data.isNotEmpty()) {
            Log.d("XMessage", "${message.data}")
        }

        message.notification?.let {
            Log.d("XMessage", "${it.body}")
        }

    }


}