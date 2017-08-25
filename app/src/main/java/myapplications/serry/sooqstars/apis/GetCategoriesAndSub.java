package myapplications.serry.sooqstars.apis;

import java.util.List;

import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Category;
import myapplications.serry.sooqstars.models.Message;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by LENOVO on 24/08/2017.
 */

public interface GetCategoriesAndSub {

    @GET(Constants.GET_CATEGORIES)
    Call<List<Category>> getCategories(@Path("id") String id);
}
