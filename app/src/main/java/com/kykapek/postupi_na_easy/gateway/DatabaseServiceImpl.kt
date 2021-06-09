package com.kykapek.postupi_na_easy.gateway

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kykapek.postupi_na_easy.repository.models.Olymp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

// Запросы в бд (выполнение)
class DatabaseServiceImpl : DatabaseService {
    val source = FirebaseDatabase.getInstance().reference

    override suspend fun getOlympsByKey(key: String): List<Olymp> {
        val list = mutableListOf<Olymp>()
        val channel = Channel<List<Olymp>>(1)
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
                    val olympLink = i.child("link").value as String
                    val item = Olymp(
                        olympName,
                        olympClasses,
                        olympItems,
                        olympDates,
                        olympLevel,
                        olympOrganizer,
                        olympLink
                    )
                    list.add(item)
                }
                CoroutineScope(Dispatchers.Default).launch {
                    channel.send(list)
                }
            }
        }
        source.addValueEventListener(getdata)
        source.addListenerForSingleValueEvent(getdata)
        return channel.receive().filter { it.name.toLowerCase().contains(key) }
    }
}