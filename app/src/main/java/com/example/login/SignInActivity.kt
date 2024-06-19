package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id=findViewById<EditText>(R.id.id)
        val pass=findViewById<EditText>(R.id.pass)

        val login=findViewById<Button>(R.id.loginbtn)
        val signup=findViewById<Button>(R.id.signupbtn)

        login.setOnClickListener {
            val idStr=id.text.toString()
            val passStr=pass.text.toString()
            if(idStr.length==0||passStr.length==0){
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
                val intent=Intent(this, HomeActivity::class.java)
                intent.putExtra("id",idStr)
                startActivity(intent)
            }
        }

        launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result->
            run{
                id.setText(result.data!!.getStringExtra("id"))
                pass.setText(result.data!!.getStringExtra("pass"))
            }
        }

        signup.setOnClickListener {
            val intent=Intent(this, SignUpActivity::class.java)
            launcher.launch(intent)
        }
    }
}