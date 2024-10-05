package com.jairbb.fragmentos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    lateinit var navegation: BottomNavigationView
    private val mOnNav = BottomNavigationView.OnNavigationItemSelectedListener  { item ->
        when (item.itemId) {
            R.id.itemfrag1 -> {
                supportFragmentManager.commit {
                    replace<primerFragment>(R.id.fragment_container)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemfrag2 -> {
                supportFragmentManager.commit {
                    replace<segundoFragment>(R.id.fragment_container)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemfrag3 -> {
                supportFragmentManager.commit {
                    replace<tercerFragment>(R.id.fragment_container)
                    setReorderingAllowed(true)
                    addToBackStack(null)
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navegation = findViewById(R.id.navegationMenu)
        navegation.setOnNavigationItemSelectedListener(mOnNav)

        supportFragmentManager.commit {
            replace<primerFragment>(R.id.fragment_container)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}