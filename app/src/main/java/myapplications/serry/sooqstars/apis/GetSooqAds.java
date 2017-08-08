package myapplications.serry.sooqstars.apis;

import java.util.List;

import myapplications.serry.sooqstars.basemodels.AdsBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Ad;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by awstreams on 8/3/17.
 */

public interface GetSooqAds {
    @GET(Constants.GET_Ads)
    Call<List<AdsBaseModel>> getSooqAds(@Query("id") String sooqId,
                              @Query("size") int size,
                              @Query("page") int page);
}
