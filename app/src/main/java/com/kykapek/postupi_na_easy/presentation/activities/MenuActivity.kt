package com.kykapek.postupi_na_easy.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.firsovam.postupi_na_easy.R
//import com.google.firebase.database.FirebaseDatabase
import com.kykapek.postupi_na_easy.gateway.DatabaseServiceImpl
import com.kykapek.postupi_na_easy.repository.AppRepositoryImpl
import kotlinx.android.synthetic.main.activity_menu.*

/**
 * @author Pavel Kulik
 */
class MenuActivity : AppCompatActivity() {

    companion object {
        val appRepository = AppRepositoryImpl()
        val database = DatabaseServiceImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        appRepository.context = this


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        btm_nav.setupWithNavController(navHostFragment.navController)
    }
}