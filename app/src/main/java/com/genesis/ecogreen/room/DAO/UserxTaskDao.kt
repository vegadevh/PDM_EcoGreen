package com.example.room_library.room.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.genesis.ecogreen.Room.Entities.Task
import com.genesis.ecogreen.Room.Entities.User
import com.genesis.ecogreen.Room.Entities.UserxTask

@Dao
interface UserxTaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend = corrutina
    suspend fun insert(ut: UserxTask)

    @Query("SELECT * FROM UserxTask")
    fun getAllUserxTask(): LiveData<List<UserxTask>>

    @Query("SELECT U.* FROM User U INNER JOIN UserxTask ON User_mail=ut_usermail WHERE ut_taskname=:Taskname")
    fun getAllUsersInThisTask(Taskname:String): LiveData<List<User>>

    @Query("SELECT T.* FROM Task T INNER JOIN UserxTask ON Task_name=ut_taskname WHERE ut_usermail=:Usermail")
    fun getAllTasksFromThisUser(Usermail:String): LiveData<List<Task>>

}