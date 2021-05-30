package com.kykapek.postupi_na_easy.gateway

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kykapek.postupi_na_easy.repository.models.Olymp

// Запросы в бд (выполнение)
class DatabaseServiceImpl : DatabaseService {
    val source = FirebaseDatabase.getInstance().reference

    override fun getOlympsByKey(key: String): List<Olymp> {
        val list = mutableListOf<Olymp>()
        val getdata = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(snapShot: DataSnapshot) {
                for (i in snapShot.children) {
                    val olympClasses = i.child("classes").value as String
                    val olympDates = i.child("dates").value as String
                    val olympItems = i.child("items").value as String
                    val olympLevel = i.child("level").value as String
                    val olympOrganizer = i.child("olympiad_is_held_by").value as String
                    val olympName = i.child("olympiads").value as String
                    val item = Olymp(
                        olympName,
                        olympClasses,
                        olympItems,
                        olympDates,
                        olympLevel,
                        olympOrganizer
                    )
                    list.add(item)
                }
            }
        }
        source.addValueEventListener(getdata)
        source.addListenerForSingleValueEvent(getdata)
        Log.i("TEST1", list.toString())
        return list.filter { it.name.startsWith(key) }
    }
}