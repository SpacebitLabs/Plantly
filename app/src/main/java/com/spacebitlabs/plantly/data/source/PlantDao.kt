package com.spacebitlabs.plantly.data.source

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.spacebitlabs.plantly.data.entities.Plant
import io.reactivex.Flowable

@Dao
interface PlantDao {

    @Query("SELECT * FROM plant")
    fun getAll(): Flowable<List<Plant>>

    @Query("SELECT * FROM plant WHERE id LIKE :id LIMIT 1")
    fun getById(id: Long): Flowable<Plant>

    @Insert(onConflict = REPLACE)
    fun insert(plant: Plant): Long

    // Not sure where this would be useful
    @Insert
    fun insertAll(plants: List<Plant>)

    @Update(onConflict = REPLACE)
    fun update(plant: Plant)

    @Delete
    fun delete(plant: Plant)

    @Query("DELETE FROM plant")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM plant")
    fun count(): Int
}