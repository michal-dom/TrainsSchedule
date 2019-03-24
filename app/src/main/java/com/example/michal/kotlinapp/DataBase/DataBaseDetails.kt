package com.example.michal.kotlinapp.DataBase

object DataBaseDetails{
    const val DB_NAME : String = "pkp_plan.db"
    const val DB_VERSION : Int = 1


    const val TABLE_NAME : String = "TRAINS"
    const val ID_COLUMN : String = "ID_TRAIN"
    const val DIRECTION_COLUMN : String = "DIRECTION"
    const val LAST_STATION_COLUMN : String = "LAST_STATION"
    const val PLATFORM_COLUMN : String = "PLATFORM"
    const val TYPE_COLUMN : String = "TYPE"
    const val DEPARTURE_COLUMN : String = "DEPARTURE_TIME"
    const val ARRIVAL_COLUMN : String = "ARRIVAL_TIME"
    const val DAYS_COLUMN : String = "DAYS"


    const val SQL_CREATE_ENTRIES = " CREATE TABLE ${TABLE_NAME} (" +
            "${ID_COLUMN} INTEGER PRIMARY KEY," +
            "${DIRECTION_COLUMN} TEXT," +
            "${LAST_STATION_COLUMN} TEXT," +
            "${PLATFORM_COLUMN} TEXT," +
            "${TYPE_COLUMN} TEXT," +
            "${DEPARTURE_COLUMN} TEXT," +
            "${ARRIVAL_COLUMN} TEXT," +
            "${DAYS_COLUMN} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"


}