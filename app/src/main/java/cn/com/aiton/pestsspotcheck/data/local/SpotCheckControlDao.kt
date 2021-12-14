package cn.com.aiton.pestsspotcheck.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cn.com.aiton.pestsspotcheck.data.entities.SpotCheckControl

@Dao
interface SpotCheckControlDao:BaseDao<SpotCheckControl> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element:SpotCheckControl)

    @Query("select * from spot_check_control")
    fun getAllStudents():MutableList<SpotCheckControl>

    @Query("select * from spot_check_control where _id = :id")
    fun getStudnet(id:Int):SpotCheckControl

    @Query("select * from spot_check_control order by _id desc ")
    fun getAllByDateDesc():MutableList<SpotCheckControl>

    @Query("delete from spot_check_control")
    fun deleteAll()
}