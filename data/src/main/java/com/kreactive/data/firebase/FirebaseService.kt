package com.kreactive.data.firebase

import com.google.firebase.database.*
import com.kreactive.domain.info.food.Food
import com.kreactive.domain.info.info.Info
import io.reactivex.Single

class FirebaseService {

    private lateinit var database: DatabaseReference

    fun getInfo(): Single<List<Info>> = Single.create { emitter ->
        database = FirebaseDatabase.getInstance().reference.child("Pregnant").child("Info")
        database.keepSynced(true)
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                if (dataSnapshot != null && dataSnapshot.exists()) {
                    val menu: MutableList<InfoFirebase> = mutableListOf()
                    dataSnapshot.children.mapNotNullTo(menu) {
                        it.getValue(InfoFirebase::class.java)
                    }
                    emitter.onSuccess(infoListMapper(menu))
                }
            }

            override fun onCancelled(p0: DatabaseError?) {
                emitter.onError(IllegalStateException())
            }
        })
    }

    fun getFood(title: String): Single<List<Food>> = Single.create { emitter ->
        database = FirebaseDatabase.getInstance().reference.child("Pregnant").child(title)
        database.keepSynced(true)
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                if (dataSnapshot != null && dataSnapshot.exists()) {
                    val menu: MutableList<FoodFirebase> = mutableListOf()
                    dataSnapshot.children.mapNotNullTo(menu) {
                        it.getValue(FoodFirebase::class.java)
                    }
                    emitter.onSuccess(foodListMapper(menu))
                }
            }

            override fun onCancelled(p0: DatabaseError?) {
                emitter.onError(IllegalStateException())
            }
        })
    }
}