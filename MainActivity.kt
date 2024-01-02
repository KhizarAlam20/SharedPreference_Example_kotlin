package com.example.nucalc

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var age:EditText
    lateinit var name:EditText

    lateinit var sf:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        age = findViewById(R.id.age)
        name = findViewById(R.id.name)

        sf  = getSharedPreferences("sfs", MODE_PRIVATE)
        editor = sf.edit()

    }

    override fun onPause() {
        super.onPause()

        var etname = name.text.toString()
        var etage = age.text.toString().toInt()

        editor.apply {
            putString("NAME",etname)
            putInt("AGE",etage)
            commit()
        }
    }


    override fun onResume() {
        super.onResume()

        var MyName = sf.getString("NAME",null)
        var MyAge = sf.getInt("AGE",0)

        name.setText(MyName)

        if(MyAge != 0)
        {
            age.setText(MyAge.toString())
        }

    }

}