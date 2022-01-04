package com.example.notes.utilits

import com.example.notes.MainActivity
import com.example.notes.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository

lateinit var EMAIL: String
lateinit var PASSWORD: String

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"