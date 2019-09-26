package com.manudev.dreamtv.presentation.preferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.manudev.dreamtv.R

/**
 * We are forced to use this Activity to apply the Leanback theme, thus obtain
 * the windows transparent and the style PreferenceTheme applied to the fragment.
 * In case this is not necessary, it could be easily done without this activity
 */
class AppPreferencesActivity : FragmentActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences_app)

    }
}