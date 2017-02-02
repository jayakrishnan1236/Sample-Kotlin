package kt.utils;

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by user on 2/2/2017.
 */

public class PreferencesHelper @Inject constructor(private var sharedPref: SharedPreferences) {

    fun put(key: String, value: String) {
        return sharedPref.edit().putString(key, value).apply()
    }

    fun getString(key: String, value :String = "") : String {
        return sharedPref.getString(key, value)
    }

    fun isKey(key:String) : Boolean{
        return sharedPref.contains(key)
    }

}
