package myapplications.serry.sooqstars.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.adapters.AdsAdapter;
import myapplications.serry.sooqstars.apis.GetSooqAds;
import myapplications.serry.sooqstars.basemodels.AdObjectBaseModel;
import myapplications.serry.sooqstars.basemodels.AdsBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import myapplications.serry.sooqstars.models.Ad;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by awstreams on 8/1/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View view;
    @BindView(R.id.btn_mehan)
    Button btnMehan;
    @BindView(R.id.btn_sooq)
    Button btnSooq;
    @BindView(R.id.btn_stars)
    Button btnStars;
    @BindView(R.id.rv_results)
    RecyclerView rvResults;
    private Retrofit retrofit;
    private AdsAdapter adsAdapter;
    private List<Ad> ads;

    public static synchronized HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        rvResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        ads = new ArrayList<>();
        adsAdapter = new AdsAdapter(getActivity(), ads);
        rvResults.setAdapter(adsAdapter);
        btnSooq.setOnClickListener(this);
        btnMehan.setOnClickListener(this);
        btnStars.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sooq:
                retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(Utils.newInstance().getClient(getActivity()))
                        .build();
                GetSooqAds getSooqAds = retrofit.create(GetSooqAds.class);
                Call<List<AdsBaseModel>> adsBaseModelCall = getSooqAds.getSooqAds();
                adsBaseModelCall.enqueue(new Callback<List<AdsBaseModel>>() {
                    @Override
                    public void onResponse(Call<List<AdsBaseModel>> call, Response<List<AdsBaseModel>> response) {
                        List<Ad> adsList = response.body().get(0).getAds();
                        ads.addAll(adsList);
                        adsAdapter.notifyItemRangeInserted(adsAdapter.getItemCount(), ads.size() - 1);
                    }

                    @Override
                    public void onFailure(Call<List<AdsBaseModel>> call, Throwable t) {
                        Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
    }
}