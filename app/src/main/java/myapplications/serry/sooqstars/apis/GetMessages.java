package myapplications.serry.sooqstars.apis;

import java.util.List;


import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Message;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by awstreams on 8/8/17.
 */

public interface GetMessages {
    @GET(Constants.GET_Messages)
    Call<List<Message>> getMessages(@Path("token") String token);
}
