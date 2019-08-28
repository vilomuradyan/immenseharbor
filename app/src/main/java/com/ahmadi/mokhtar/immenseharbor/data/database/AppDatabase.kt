package com.ahmadi.mokhtar.immenseharbor.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahmadi.mokhtar.immenseharbor.data.models.Department
import com.ahmadi.mokhtar.immenseharbor.data.models.LoginResponse

@Database(entities = [Department::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val departmentDao:DepartmentDao
}