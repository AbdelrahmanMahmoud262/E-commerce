package com.androdevelopment.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.androdevelopment.e_commerce.Fragments.CartFragment
import com.androdevelopment.e_commerce.Fragments.HomeFragment
import com.google.android.material.navigation.NavigationView

private lateinit var toggle: ActionBarDrawerToggle
private lateinit var drawerLayout: DrawerLayout
private lateinit var navigationView: NavigationView
private lateinit var buttonOpenNav: ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        buttonOpenNav = findViewById(R.id.imageButtonOpenNav)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(HomeFragment())

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                }

                R.id.menu_cart -> {
                    replaceFragment(CartFragment())
                }
            }
            drawerLayout.close()
            true
        }

        buttonOpenNav.setOnClickListener {
            drawerLayout.openDrawer(navigationView,true)
        }

    }

    private fun replaceFragment(fragment:Fragment){
        val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()

        transaction.apply {
            replace(R.id.frameLayoutMain,fragment)
            commit()
        }
    }
}