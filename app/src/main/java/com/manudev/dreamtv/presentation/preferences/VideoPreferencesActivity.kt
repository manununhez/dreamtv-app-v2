package com.manudev.dreamtv.presentation.preferences

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.manudev.dreamtv.R

class VideoPreferencesActivity : FragmentActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences_video)

    }
}