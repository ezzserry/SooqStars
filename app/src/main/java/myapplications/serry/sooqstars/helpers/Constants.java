package myapplications.serry.sooqstars.helpers;

/**
 * Created by PC on 7/24/2017.
 */

public class Constants {

    final public static String isLoggedIn = "loggedIn";
    final public static String MyPrefs = "MyPrefs";
    final public static String User_Token = "user_token";
    /*apis*/
    final public static String BASE_URL = "http://demo.sooqstars.com/SoooogAPIs/api/v1/";
    final public static String SignIn_URL = BASE_URL + "user/token";
    final public static String Register_URL = BASE_URL + "user/post";
    final public static String _GET_Notifications = BASE_URL + "notification/token/";
    final public static String _GET_Messages = BASE_URL + "message/token/";
    final public static String GET_Sooq_Ads = BASE_URL + "ad/recent?id=1&size=20&page=1";
    final public static String GET_Mehan_Ads = BASE_URL + "ad/recent?id=2&size=20";
    final public static String GET_Stars_Ads = BASE_URL + "ad/recent?id=3&size=20";
    final public static String GET_Cities = BASE_URL + "city/get";
}
