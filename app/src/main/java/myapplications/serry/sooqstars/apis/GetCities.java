package myapplications.serry.sooqstars.apis;

import java.util.List;

import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Cities;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by awstreams on 8/8/17.
 */

public interface GetCities {
    @GET(Constants.GET_Cities)
    Call<List<Cities>> getCities();
}
