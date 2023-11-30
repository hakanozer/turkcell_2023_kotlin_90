package com.works.days_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.works.days_9.configs.DB
import com.works.days_9.entities.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, DB::class.java, "projeDbName" ).build()
        val note = Note(null, "Toplantı Note", "Note Detay", 1)

        /*
        val run = Runnable {
            val insertStatus = db.noteDao().insert(note)
            Log.d("insertStatus", insertStatus.toString())
        }
        Thread(run).start()
         */

        val run = CoroutineScope(Dispatchers.IO).launch {
            val insertStatus = db.noteDao().insert(note)
            Log.d("insertStatus", insertStatus.toString())
        }
        run.start()





    }
}