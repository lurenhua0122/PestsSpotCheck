package cn.com.aiton.pestsspotcheck.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cn.com.aiton.pestsspotcheck.MainApplication
import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl

@Database(entities = [SpotCheckControl::class], exportSchema = false,version = 1)
abstract class SpotCheckDatabase: RoomDatabase() {
    abstract fun getSpotCheckControlDao(): SpotCheckControlDao
//    abstract fun getTeacherDao(): TeacherDao

    companion object {
        val instance = Single.sin
    }

    private object Single {
        val sin :SpotCheckDatabase= Room.databaseBuilder(
            MainApplication.instance(),
            SpotCheckDatabase::class.java,
            "User.db"
        )
            .allowMainThreadQueries()
            .build()
    }
}