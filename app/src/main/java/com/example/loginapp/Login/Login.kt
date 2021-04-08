package com.example.loginapp.Login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.HomeActivity
import com.example.loginapp.R
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class Login:AppCompatActivity() {
    private val SHARED_PREFS = "shared_prefs"
    private val NAME_KEY = "name_key"
    private val PASSWORD_KEY = "password_key"
    private val mapKey = "map1"
    private var map: HashMap<String, String> = hashMapOf()
    lateinit var sName: String
    lateinit var sPass: String
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var username: String
    private lateinit var password: String
    private var mapper = ObjectMapper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginscreen)

        val name = findViewById<EditText>(R.id.Name)
        val pass = findViewById<EditText>(R.id.Password)
        val email = findViewById<EditText>(R.id.mail)
        val login = findViewById<Button>(R.id.mainlogin)

        username = email.text.toString().trim()
        password = pass.text.toString().trim()
        sharedPreferences = this.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        sName = sharedPreferences.getString(NAME_KEY, null).toString()
        sPass = sharedPreferences.getString(PASSWORD_KEY, null).toString()
        val editor:SharedPreferences.Editor=sharedPreferences.edit()

      login.setOnClickListener(View.OnClickListener {
          username = email.text.toString().trim()
          password = pass.text.toString().trim()
          if (username != null && password != null) {
              try {
                  map = mapper.readValue(File(getExternalFilesDir(null), "result.json"),
                          object : TypeReference<Map<String?, Any?>?>() {})
              } catch (e: Exception) {
                  e.printStackTrace()
              }
              if (map.keys.toString().contains(username) && map.values.toString().contains(password)) {

                  if(map[username]==password) {
                      Toast.makeText(this, "Logged-in Successfully", Toast.LENGTH_SHORT).show()
                      editor.putString("login","true")
                      editor.commit()
                      val i = Intent(this, HomeActivity::class.java)
                      startActivity(i)
                      finish()
                  }


              } else {
                  Toast.makeText(this, "else key : $sName $sPass", Toast.LENGTH_SHORT).show()
              }
          }
      })

    }
}