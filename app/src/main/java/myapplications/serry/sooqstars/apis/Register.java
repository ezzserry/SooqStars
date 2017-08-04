package myapplications.serry.sooqstars.apis;

import myapplications.serry.sooqstars.basemodels.SignInBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by PC on 7/26/2017.
 */

public interface Register {
    @POST(Constants.Register_URL)
    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    Call<SignInBaseModel> register(
            @Field("nickname") String nickname,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("CountryPhoneCode") String countrycode);
}
