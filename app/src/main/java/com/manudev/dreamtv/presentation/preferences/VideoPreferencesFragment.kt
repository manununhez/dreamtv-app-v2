package com.manudev.dreamtv.presentation.preferences


import android.content.SharedPreferences
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class VideoPreferencesFragment : LeanbackSettingsFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Apply leanback theme to preferences
        val contextThemeWrapper = ContextThemeWrapper(requireActivity(), R.style.LeanbackPreferences)

        val cloneInContext = inflater.cloneInContext(contextThemeWrapper)

        return super.onCreateView(cloneInContext, container, savedInstanceState)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
            // Load the preferences from an XML resource
            setPreferencesFromResource(R.xml.video_preferences, rootKey)
        }
    }

}