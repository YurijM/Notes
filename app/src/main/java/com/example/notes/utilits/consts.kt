package com.example.notes.utilits

import com.example.notes.MainActivity
import com.example.notes.database.DatabaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var DATABASE_REF: DatabaseReference

lateinit var EMAIL: String
lateinit var PASSWORD: String

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

const val ID_FIREBASE = "idFirebase"
const val TITLE = "title"
const val TEXT = "text"