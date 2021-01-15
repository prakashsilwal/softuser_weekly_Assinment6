package com.prakash.softwaricaclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private var studentArrayList=ArrayList<student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername=findViewById(R.id.etUserName)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)


        btnLogin.setOnClickListener(this)
    }

    private fun isValid():Boolean{
        when{
            etUsername.text.isEmpty()==true->{
                etUsername.error="Please enter username"
                return false
            }

            etPassword.text.isEmpty()==true->{
                etPassword.error="please enter password"
                return false
            }
        }
        return true
    }

    private fun userValidator():Boolean{
        val userName=etUsername.text.toString()
        val password=etPassword.text.toString()
        if(userName=="softwarica" && password=="coventry"){
            return true
        }
        return false
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin -> {
                if (isValid()) {
                    if (userValidator()) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Invalid username/password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}