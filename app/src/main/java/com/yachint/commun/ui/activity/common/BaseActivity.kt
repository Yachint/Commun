package com.yachint.commun.ui.activity.common

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.yachint.commun.R
import com.yachint.commun.data.sharedprefs.PreferencesHelper
import com.yachint.commun.data.sharedprefs.PreferencesHelper.get
import com.yachint.commun.data.sharedprefs.SharedPrefKeys
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseActivity: AppCompatActivity() {
    open lateinit var prefs: SharedPreferences

    fun initPrefs(){
        lifecycleScope.launch {
            val operation = async {
                prefs = PreferencesHelper.appPrefs(this@BaseActivity)
            }

            operation.await()
        }
    }

    fun initTheme(){
        lifecycleScope.launch {
            val operation = async {
                prefs = PreferencesHelper.appPrefs(this@BaseActivity)
            }

            operation.await()
            if (prefs[SharedPrefKeys.APP_THEME.toString(), "Dark"].equals("Dark")){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                setTheme(R.style.DarkTheme);
            } else {
                setTheme(R.style.LightTheme);
            }
        }
    }
}