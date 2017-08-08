package myapplications.serry.sooqstars.helpers;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by PC on 7/24/2017.
 */

public class Constants {


    public static String font = "font.ttf";

    public static Typeface typeface;
    public static Typeface getTypeFace(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(), font);
        return typeface;
    }

    final public static String isLoggedIn = "loggedIn";
    final public static String MyPrefs = "MyPrefs";
    final public static String User_Token = "user_token";
    /*apis*/
    final public static String BASE_URL = "http://demo.sooqstars.com/SoooogAPIs/api/v1/";
    final public static String SignIn_URL = BASE_URL + "user/token";
    final public static String Register_URL = BASE_URL + "user/post";
    final public static String GET_Notifications = BASE_URL + "notification/token/{token}";
    final public static String GET_Messages = BASE_URL + "message/token/{token}";
    final public static String GET_Ads = BASE_URL + "ad/recent";
    final public static String GET_Cities = BASE_URL + "city/get";

    /*apis info*/
    final public static String SOOQ_ID = "1";
    final public static String MEHAN_ID = "2";
    final public static String STARS_ID = "3";
    final public static int resultSize=5;
}
