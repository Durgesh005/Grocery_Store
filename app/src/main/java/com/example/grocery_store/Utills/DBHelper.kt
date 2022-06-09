package com.example.grocery_store.Utills

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity
import com.example.grocery_store.Fragments.HomeFragment
import com.example.grocery_store.Modal_Data.ProductModalData

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, "GROCERY.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        var query =
            "CREATE TABLE Grocery (id INTEGER PRIMARY KEY AUTOINCREMENT,OrderID  INTEGER,ProductName TEXT,Price INTEGER)";
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertData(id1: String, name1: String, price1: String) {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put("OrderID", id1)
        cv.put("ProductName", name1)
        cv.put("Price", price1)

        var ret = db.insert("Grocery", null, cv)
        println(ret)
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<ProductModalData> {
        var list = arrayListOf<ProductModalData>()
        var db = readableDatabase
        var query = "SELECT * from Grocery"
        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("OrderID"))
                var name = cursor.getString(cursor.getColumnIndex("ProductName"))
                var price = cursor.getString(cursor.getColumnIndex("Price"))

                var l1 = ProductModalData(id, name, price)
                list.add(l1)

            } while (cursor.moveToNext())

        }
        return list
    }

    fun deleteData(id: String) {
        var db = writableDatabase

        db.delete("Grocery", "id = $id", null)
    }
}