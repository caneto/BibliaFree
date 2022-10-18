package br.cap.sistemas.bibliacelular.classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Date;

import br.cap.sistemas.bibliacelular.R;


public class SharedPreferencesUtil {

	public static boolean contains(Context context, String key) {
		
		SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_id), Context.MODE_MULTI_PROCESS);
		return sharedPreferences.contains(key);
	}
	
	public static void save(Context context, String key, String value) {
		
		SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_id), Context.MODE_MULTI_PROCESS);
		Editor editor = sharedPreferences.edit();

		editor.putString(key, value);
		editor.commit();
	}

    public static void remove(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_id), Context.MODE_MULTI_PROCESS);
        Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key) {

        String bool = SharedPreferencesUtil.get(context, key);
        boolean getBool = false;

        if (!StringUtil.isNullOrEmpty(bool))
            getBool = Boolean.parseBoolean(bool);

        return getBool;
    }

	public static Date getDate(Context context, String key) {

		Date date = null;

		String data = SharedPreferencesUtil.get(context, key);

		if (!StringUtil.isNullOrEmpty(data))
			date = DateUtil.parseDate(data);

		return date;
	}

	public static int getInteger(Context context, String key) {

		String integer = SharedPreferencesUtil.get(context, key);
		int getInt = 0;

		if (!StringUtil.isNullOrEmpty(integer))
			getInt = Integer.parseInt(integer);

		return getInt;
	}
	
	public static String get(Context context, String key) {

		SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_id), Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getString(key, "");
	}
}
