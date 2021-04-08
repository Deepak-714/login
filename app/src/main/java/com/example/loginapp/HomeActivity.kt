package com.example.loginapp


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.loginapp.API.MainActivity1
import com.example.loginapp.Fragment.ProfileFragment
import com.example.loginapp.Fragment.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.loginapp.Fragment.Dashboard as Dashboard


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val main=MainActivity1()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener(this)
        loadfragment(Dashboard())


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? =null
        when(item.itemId)
        {
            R.id.dashboard -> {
                val fragment = Dashboard()
                val commit = supportFragmentManager.beginTransaction().replace(R.id.mainH, fragment,main.javaClass.simpleName)
                        .commit()
                return true
            }
            R.id.user-> {
                val fragment = UserFragment()
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }
            R.id.profile -> {
                val fragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return  true
            }

        }
        return true


    }

    fun loadfragment(fragment:Fragment)
    {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativeLayout, fragment).commit()

    }

}