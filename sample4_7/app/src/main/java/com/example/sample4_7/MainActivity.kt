package com.example.sample4_7

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val builder = AlertDialog.Builder(this)


        builder.setTitle("타이틀")
            .setMessage("메세지")
            .setPositiveButton("확인", DialogInterface.OnClickListener{
                dialog, id ->
                //확인버튼 누를때 실행하는코드
                Toast.makeText(this@MainActivity,"확인을 눌렀네요", Toast.LENGTH_SHORT)
            })
            .setNegativeButton("최소",DialogInterface.OnClickListener{
                dialog,id ->
                //취소버튼 누를때 실행하는 코드
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.daum.net"))
                    startActivity(intent)
            })
        builder.show()
    }
}