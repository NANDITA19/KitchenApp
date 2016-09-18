package extra;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rakshit on 09-09-2016 at 09:15.
 */

public class PrefManager
{

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "kitchen-app";

    private static final String IS_FIRST_TIME_LAUNCH = "is_first_launch";

    public PrefManager(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime)
    {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch()
    {
        //return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
        return true;
    }

    public String getUserId(){
        return pref.getString("user_id","1");
    }

    public String getUserDisplayName(){
        return  pref.getString("user_display_name","rutvik106");
    }

}
