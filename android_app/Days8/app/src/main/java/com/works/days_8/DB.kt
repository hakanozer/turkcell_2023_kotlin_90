package com.works.days_8

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(context: Context) : SQLiteOpenHelper(context, DBName , null, version) {

    companion object {
        private val DBName = "proje.db"
        private val version = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val userTable = "CREATE TABLE \"users\" (\n" +
                "\t\"uid\"\tINTEGER UNIQUE,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"email\"\tTEXT UNIQUE,\n" +
                "\t\"password\"\tTEXT,\n" +
                "\t\"phone\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"uid\" AUTOINCREMENT)\n" +
                ");"
        p0?.execSQL(userTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val userTableDrop = "drop table if exists users";
        p0?.execSQL(userTableDrop)
        onCreate(p0)
    }

    fun addUser( name: String, email: String, password: String, phone: String ) : Long {
        val db = this.writableDatabase // insert, Delete, Update
        val content = ContentValues()
        content.put("name", name)
        content.put("email", email)
        content.put("password", password)
        content.put("phone", phone)
        val newID = db.insert("users", null, content)
        return newID
    }

    fun deleteUser( uid: Int ) : Int {
        val db = this.writableDatabase
        val status = db.delete("users", "uid = $uid", null)
        return status
    }
    


}