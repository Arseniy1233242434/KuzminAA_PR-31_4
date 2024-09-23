package com.example.pr1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class result : AppCompatActivity() {
    lateinit var text1:TextView
    lateinit var text2:TextView
    lateinit var text3:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        text1=findViewById(R.id.t1)
        text2=findViewById(R.id.t2)
        text3=findViewById(R.id.t3)
        text1.setText("Сумма кредита:"+intent.getStringExtra("sum"))
        text2.setText("Срок кредита(мес):"+intent.getStringExtra("date"))
        var a=intent.getStringExtra("date")?.toDouble()
        var b=intent.getStringExtra("sum")?.toDouble()
        if (a != null)
        {
            if (a <= 12)
            {
                if (b != null)
                {
                    val df =DecimalFormat("#.##")
                    text3.setText("ежемесячный платёж:" + ((b / a) + (b/100*5.9)))
                }
            }
            if (a > 12 && a < 24)
            {
                if (b != null)
                {
                    text3.setText("ежемесячный платёж:" + (b / a) + (b/100*5.1))
                }
            }
            else
            {
                if (b != null) {
                    text3.setText("ежемесячный платёж:" + (b / a) + (b/100*4.2))
                }
            }
        }
        else
        {

        }
    }

    fun f(view: View)
    {
        val intent = Intent(this, registr::class.java)
        startActivity(intent)
    }
}