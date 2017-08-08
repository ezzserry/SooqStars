package myapplications.serry.sooqstars.apis;

import java.util.List;

import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Message;
import myapplications.serry.sooqstars.models.Notification;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by awstreams on 8/8/17.
 */

public interface GetNotifications {

    @GET(Constants.GET_Notifications)
    Call<List<Notification>> getNotifications(@Path("token") String token);
}
