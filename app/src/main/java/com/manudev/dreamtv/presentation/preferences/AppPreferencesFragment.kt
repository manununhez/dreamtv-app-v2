package com.manudev.dreamtv.presentation.preferences

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.leanback.preference.LeanbackPreferenceFragmentCompat
import androidx.leanback.preference.LeanbackSettingsFragmentCompat
import androidx.preference.Preference
import androidx.preference.PreferenceDialogFragmentCompat
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.manudev.dreamtv.R

/**
 * A simple [Fragment] subclass.
 */
class AppPreferencesFragment : LeanbackSettingsFragmentCompat() {


    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        val args = pref?.extras
        val f = childFragmentManager.fragmentFactory.instantiate(
            requireActivity().classLoader, pref?.fragment.toString()
        )
        f.arguments = args
        f.setTargetFragment(caller, 0)
        if (f is PreferenceFragmentCompat || f is PreferenceDialogFragmentCompat) {
            startPreferenceFragment(f)
        } else {
            startImmersiveFragment(f)
        }
        return true
    }

    override fun onPreferenceStartScreen(
        caller: PreferenceFragmentCompat?,
        pref: PreferenceScreen?
    ): Boolean {
        val fragment = PrefFragment()
        val args = Bundle(1)
        args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, pref?.key)
        fragment.arguments = args
        startPreferenceFragment(fragment)
        return true
    }


    override fun onPreferenceStartInitialScreen() {
        startPreferenceFragment(PrefFragment())
    }


    /**
     * The fragment that is embedded in SettingsFragment
     */
    class PrefFragment : LeanbackPreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.app_preferences, rootKey)
        }

    }

}
