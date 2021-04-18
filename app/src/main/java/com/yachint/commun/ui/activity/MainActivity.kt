package com.yachint.commun.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yachint.commun.R
import com.yachint.commun.databinding.ActivityMainBinding
import com.yachint.commun.ui.activity.common.BaseActivity
import com.yachint.commun.ui.fragment.ExploreFragment
import com.yachint.commun.ui.fragment.HomeFragment
import com.yachint.commun.ui.fragment.ProfileFragment

class MainActivity : BaseActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    val homeFragment = HomeFragment()
    val exploreFragment = ExploreFragment()
    val profileFragment = ProfileFragment()
    var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTheme()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder, homeFragment, "home").commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder, exploreFragment, "explore")
            .hide(exploreFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder, profileFragment, "profile")
            .hide(profileFragment).commit()



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(homeFragment).commit()
                activeFragment = homeFragment
                true
            }

            R.id.menu_explore -> {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(exploreFragment).commit()
                activeFragment = exploreFragment
                true
            }

            R.id.menu_profile -> {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(profileFragment).commit()
                activeFragment = profileFragment
                true
            }
            else -> {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(homeFragment)
                activeFragment = homeFragment
                true
            }
        }
    }
}