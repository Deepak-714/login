package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.example.loginapp.Login.CreateAccount
import com.example.loginapp.Login.Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"in a main ",LENGTH_LONG).show()

        val login=findViewById<Button>(R.id.login)
        val SignIn=findViewById<Button>(R.id.signIn)

        login.setOnClickListener(View.OnClickListener {
            Toast.makeText(this," click on login button", LENGTH_LONG).show()
            val i=Intent(this,Login::class.java)
            startActivity(i)

        })

          SignIn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"click the sign in ", LENGTH_LONG).show()
            val i=Intent(this,CreateAccount::class.java)
            startActivity(i)

        })

    }
}