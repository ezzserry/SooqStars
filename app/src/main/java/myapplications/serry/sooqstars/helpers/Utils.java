package myapplications.serry.sooqstars.helpers;

import android.app.ProgressDialog;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 7/24/2017.
 */

public class Utils {
    public static ProgressDialog loading = null;
    public static Retrofit retrofit;

    public static Utils newInstance() {
        return new Utils();
    }


    public void showLoading(Context context) {
        loading = new ProgressDialog(context);
        loading.setCancelable(false);
        loading.setMessage("Loading ");
        loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loading.show();
    }

    public void dismissLoading() {
        loading.dismiss();
    }

    public Retrofit getRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient())
                .build();
        return retrofit;
    }

    public OkHttpClient getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(10, TimeUnit.SECONDS);
        client.writeTimeout(10, TimeUnit.SECONDS);
        client.readTimeout(10, TimeUnit.SECONDS);
        return client.build();
    }
}
