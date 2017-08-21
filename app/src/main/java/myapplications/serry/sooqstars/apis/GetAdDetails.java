package myapplications.serry.sooqstars.apis;

import java.util.List;

import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Ad;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by awstreams on 8/21/17.
 */

public interface GetAdDetails {

    @GET(Constants.GET_AD_Details)
    Call<List<Ad>> getAdDetails(@Path("id") String adId);
}
