package myapplications.serry.sooqstars.apis;

import myapplications.serry.sooqstars.basemodels.SignInBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by PC on 7/24/2017.
 */

public interface SignIn {
    @POST(Constants.SignIn_URL)
    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    Call<SignInBaseModel> signIn(
            @Field("username") String username,
            @Field("password") String password);
}
