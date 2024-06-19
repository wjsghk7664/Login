package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name=findViewById<EditText>(R.id.name)
        val id=findViewById<EditText>(R.id.idup)
        val pass=findViewById<EditText>(R.id.passup)

        val signUpBtn=findViewById<Button>(R.id.signupbtnup)

        signUpBtn.setOnClickListener {


            val nameStr=name.text.toString()
            val idStr=id.text.toString()
            val passStr=pass.text.toString()

            if(nameStr.length==0||idStr.length==0||passStr.length==0){
                Toast.makeText(this,"입력되지 않은 정보가 있습니다",Toast.LENGTH_SHORT).show()
            }else{
                val intent=Intent(this,SignInActivity::class.java)
                intent.putExtra("id",idStr)
                intent.putExtra("pass",passStr)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}