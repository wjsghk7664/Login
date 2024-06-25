package com.example.login

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageview=findViewById<ImageView>(R.id.randomImage)

        val random=Random()
        val num=random.nextInt(5)

        when(num){
            0->imageview.setImageResource(R.drawable.image1)
            1->imageview.setImageResource(R.drawable.image2)
            2->imageview.setImageResource(R.drawable.image3)
            3->imageview.setImageResource(R.drawable.image4)
            else->imageview.setImageResource(R.drawable.sparta)
        }


        val idstr=intent.getStringExtra("id")
        val id=findViewById<TextView>(R.id.idTextView)
        id.setText("아이디:"+idstr)

        val end=findViewById<ConstraintLayout>(R.id.finish_button)

        val btnText=findViewById<TextView>(R.id.pressed_text)
        val btnImage=findViewById<ImageView>(R.id.pressed_icon)

        end.setOnTouchListener { v: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    btnText.setTextColor(Color.WHITE)
                    btnImage.setImageResource(R.drawable.clicked_icon)
                    false
                }
                MotionEvent.ACTION_MOVE ->{
                    if(!end.isPressed) {
                        btnText.setTextColor(Color.BLACK)
                        btnImage.setImageResource(R.drawable.unclicked_icon)
                    }

                    false
                }
                else -> false
            }
        }
        end.setOnClickListener {
            finish()
        }
    }
}