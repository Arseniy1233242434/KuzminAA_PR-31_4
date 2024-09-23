package com.example.pr1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class registr : AppCompatActivity() {
    lateinit var sh:SharedPreferences
    lateinit var ed:Editor
    lateinit var log:EditText
    lateinit var pass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_registr)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun v(view: View)
    {
        sh=this.getSharedPreferences("gh", Context.MODE_PRIVATE)
        log=findViewById(R.id.login)
        pass=findViewById(R.id.password)

        if(log.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty())
        {
            if(sh.getString("log","dfg")==null) {
                ed = sh.edit()
                ed.putString("log", log.text.toString())
                ed.putString("pass", pass.text.toString())
                ed.apply()
                val inteny = Intent(this, calk::class.java)
                startActivity(inteny)
            }
            else
            {
                if(log.text.toString()==sh.getString("log","dfg")&&pass.text.toString()==sh.getString("pass","dfd"))
                {
                    val inteny = Intent(this, calk::class.java)
                    startActivity(inteny)
                }
                else {
                    val alert = AlertDialog.Builder(this).setTitle("error")
                        .setMessage("Неправильный логин и пароль").create().show()
                }
            }
        }
        else
        {
            val alert=AlertDialog.Builder(this).setTitle("error").setMessage("Не все поля заполнены").create().show()
        }
            }
    }
