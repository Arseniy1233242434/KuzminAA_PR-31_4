package com.example.pr1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class calk : AppCompatActivity() {
    lateinit var slider:Slider
    lateinit var edit:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calk)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun с(view: View)
    {

        slider=findViewById(R.id.sl)
        edit=findViewById(R.id.sr)
        if(edit.text.toString().isNotEmpty()) {
            val intent = Intent(this, result::class.java)
            intent.putExtra("sum", slider.value.toString())
            intent.putExtra("date", edit.text.toString())
            startActivity(intent)
        }
        else
        {
            val alert=
                AlertDialog.Builder(this).setTitle("error").setMessage("Не все поля заполнены").create().show()
        }
    }

    fun f1(view: View)
    {
        val intent = Intent(this, registr::class.java)
        startActivity(intent)
    }
}