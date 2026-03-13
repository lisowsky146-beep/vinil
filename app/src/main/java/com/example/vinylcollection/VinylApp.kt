package com.example.vinylcollection

import android.app.Application
import androidx.room.Room
import com.example.vinylcollection.data.VinylDatabase
import com.example.vinylcollection.data.VinylRepository

class VinylApp : Application() {

    lateinit var repository: VinylRepository
        private set

    override fun onCreate() {
        super.onCreate()

        val db = Room.databaseBuilder(
            applicationContext,
            VinylDatabase::class.java,
            "vinyl_db"
        ).fallbackToDestructiveMigration().build()

        repository = VinylRepository(db.recordDao())
    }
}
