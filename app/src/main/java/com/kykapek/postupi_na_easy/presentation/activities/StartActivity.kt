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
            //val database = FirebaseDatabase.getInstance().reference
            //val step = database.setValue("я даун")
            //step.addOnCompleteListener {
            //    Log.i("Test", "Comp")
            //}
            //step.addOnCanceledListener {
            //    Log.i("Test", "Can")
            //}
            //step.addOnFailureListener {
            //    Log.e("Test", "Fail", it)
            //}
        }

    }
}