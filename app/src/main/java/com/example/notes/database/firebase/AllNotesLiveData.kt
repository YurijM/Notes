package com.example.notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.models.AppNote
import com.example.notes.utilits.DATABASE_REF
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllNotesLiveData: LiveData<List<AppNote>>() {
    private val listener = object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map {
                it.getValue(AppNote::class.java)?:AppNote()
            }
        }

        override fun onCancelled(error: DatabaseError) {
        }

    }

    override fun onActive() {
        DATABASE_REF.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        DATABASE_REF.removeEventListener(listener)
        super.onInactive()
    }
}