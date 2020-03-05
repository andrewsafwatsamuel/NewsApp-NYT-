package com.andrew.newsapp.domain.newsDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.andrew.newsapp.entities.DbNewsPiece
import kotlinx.coroutines.Deferred

@Dao
interface TopStoriesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNews(news: List<DbNewsPiece>?)

    @Query("DELETE FROM DbNewsPiece WHERE NOT isFavourite")
    fun deleteAll()

    @Query("SELECT * FROM DbNewsPiece")
    fun queryAll(): LiveData<List<DbNewsPiece>>

    @Query("SELECT * FROM DbNewsPiece WHERE isFavourite")
    fun queryFavourites(): LiveData<List<DbNewsPiece>>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateItem(story: DbNewsPiece)
}