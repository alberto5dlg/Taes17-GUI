package com.taes.paula.aidhurt;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Alberto on 4/4/17.
 */

public class SaveSharedPreference
{
    static final String PREF_USER_NAME= "";
    static final int ID_USER=1;

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);

        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static int getIdUser(Context ctx){
        return getSharedPreferences(ctx).getInt("",ID_USER);
    }
}