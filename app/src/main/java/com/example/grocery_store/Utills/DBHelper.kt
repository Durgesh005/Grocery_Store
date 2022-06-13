package com.example.grocery_store.Utills

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.grocery_store.Modal_Data.DataBaseModal

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, "GROCERY.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query =
            "CREATE TABLE Grocery (id INTEGER PRIMARY KEY AUTOINCREMENT,ProductName  Text,Quantity INTEGER,Price INTEGER)";
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


    fun insertData(id1: String, i: Int, i1: Int) {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put("ProductName", id1)
        cv.put("Quantity", i)
        cv.put("Price", i1)

        var ret = db.insert("Grocery", null, cv)
        println(ret)
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<DataBaseModal> {

        var list = arrayListOf<DataBaseModal>()
        var db = readableDatabase
        var quary = "SELECT * from Grocery"

        var cursor = db.rawQuery(quary, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("ProductName"))
                var quantity = cursor.getString(cursor.getColumnIndex("Quantity"))
                var price = cursor.getString(cursor.getColumnIndex("Price"))

                var l1 = DataBaseModal(id, name, quantity, price)
                list.add(l1)
            } while (cursor.moveToNext())
        }
        return list

    }

    /*  fun deleteData(id: String) {
          var db = writableDatabase

          db.delete("Grocery", "id = $id", null)
      }*/
}