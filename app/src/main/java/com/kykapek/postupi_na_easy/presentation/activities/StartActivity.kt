package com.firsovam.postupi_na_easy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kykapek.postupi_na_easy.presentation.activities.MenuActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startbutton.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}