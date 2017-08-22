package myapplications.serry.sooqstars.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.adapters.AdsAdapter;
import myapplications.serry.sooqstars.apis.GetCities;
import myapplications.serry.sooqstars.apis.GetSooqAds;
import myapplications.serry.sooqstars.basemodels.AdsBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.EndlessRecyclerViewScrollListener;
import myapplications.serry.sooqstars.helpers.Utils;
import myapplications.serry.sooqstars.interfaces.OnAdClickListener;
import myapplications.serry.sooqstars.models.Ad;
import myapplications.serry.sooqstars.models.Cities;
import myapplications.serry.sooqstars.models.Districts;
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
    @BindView(R.id.pb_ads)
    ProgressBar pbAds;
    private Retrofit retrofit;
    private AdsAdapter adsAdapter;
    private LinearLayoutManager layoutManager;
    private List<Ad> ads;
    private int adPage = 1;
    private String RequestID = "";
    //    @BindView(R.id.spinner_city)
//    Spinner spinnerCity;
//    @BindView(R.id.spinner_district)
//    Spinner spinnerDistrict;
    List<Cities> citiesList;
    List<String> sDistricts;
    private ArrayAdapter<String> dataAdapter;

    public static synchronized HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        initViews();
    }

    private void initViews() {
        ads = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        rvResults.setLayoutManager(layoutManager);
        rvResults.setItemAnimator(new DefaultItemAnimator());
        adsAdapter = new AdsAdapter(getActivity(), ads);
        rvResults.setAdapter(adsAdapter);

        btnSooq.setOnClickListener(this);
        btnMehan.setOnClickListener(this);
        btnStars.setOnClickListener(this);
        RequestID = Constants.SOOQ_ID;
        rvResults.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                adPage++;
                getSooqAds(adPage, RequestID);

            }
        });
        scaleButtons(Constants.SOOQ_ID);
        getSooqAds(adPage, Constants.SOOQ_ID);

        citiesList = new ArrayList<>();

//        getCities();
    }

   /* private void getCities() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient(getActivity()))
                .build();
        GetCities getCities = retrofit.create(GetCities.class);
        Call<List<Cities>> listCall = getCities.getCities();
        listCall.enqueue(new Callback<List<Cities>>() {
            @Override
            public void onResponse(Call<List<Cities>> call, final Response<List<Cities>> response) {
                citiesList = response.body();
                fillCitiesSpinner(citiesList);
            }

            @Override

            public void onFailure(Call<List<Cities>> call, Throwable t) {

            }
        });
    }*/

   /* private void fillCitiesSpinner(final List<Cities> citiesList) {
        List<String> citiesNames = new ArrayList<>();

        for (int i = 0; i < citiesList.size(); i++) {
            String name = citiesList.get(i).getName();
            citiesNames.add(name);
        }

        if (getActivity() != null) {
            dataAdapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_spinner_item, citiesNames);
        } else


            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(dataAdapter);


        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<Districts> districtsList = citiesList.get(i).getDistricts();
                List<String> districtNames = new ArrayList<>();
                for (int j = 0; j < districtsList.size(); j++) {
                    String name = districtsList.get(j).getName();
                    districtNames.add(name);
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_spinner_item, districtNames);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDistrict.setAdapter(dataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }*/


    @Override
    public void onClick(View view) {
        int size = this.ads.size();
        this.ads.clear();
        adsAdapter.notifyItemRangeRemoved(0, size);
        pbAds.setVisibility(View.VISIBLE);
        rvResults.setVisibility(View.GONE);
        switch (view.getId()) {
            case R.id.btn_sooq:
                RequestID = Constants.SOOQ_ID;
                scaleButtons(RequestID);
                getSooqAds(1, Constants.SOOQ_ID);
                break;

            case R.id.btn_mehan:
                RequestID = Constants.MEHAN_ID;
                scaleButtons(RequestID);
                getSooqAds(1, Constants.MEHAN_ID);
                break;

            case R.id.btn_stars:
                RequestID = Constants.STARS_ID;
                scaleButtons(RequestID);
                getSooqAds(1, Constants.STARS_ID);
                break;
        }
    }

    private void scaleButtons(String requestID) {
        switch (requestID) {
            case "1":
                btnSooq.setScaleX((float) 1.1);
                btnSooq.setScaleY((float) 1.1);
                btnStars.setScaleX((float) 0.8);
                btnStars.setScaleY((float) 0.8);
                btnMehan.setScaleX((float) 0.8);
                btnMehan.setScaleY((float) 0.8);
                break;
            case "2":
                btnMehan.setScaleX((float) 1.1);
                btnMehan.setScaleY((float) 1.1);
                btnSooq.setScaleX((float) 0.8);
                btnSooq.setScaleY((float) 0.8);
                btnStars.setScaleX((float) 0.8);
                btnStars.setScaleY((float) 0.8);
                break;
            case "3":
                btnStars.setScaleX((float) 1.1);
                btnStars.setScaleY((float) 1.1);
                btnSooq.setScaleX((float) 0.8);
                btnSooq.setScaleY((float) 0.8);
                btnMehan.setScaleX((float) 0.8);
                btnMehan.setScaleY((float) 0.8);
                break;

        }
    }


    private void getSooqAds(int page, String id) {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient(getActivity()))
                .build();
        GetSooqAds getSooqAds = retrofit.create(GetSooqAds.class);
        Call<List<AdsBaseModel>> adsBaseModelCall = getSooqAds.getSooqAds(id, Constants.resultSize, page);
        adsBaseModelCall.enqueue(new Callback<List<AdsBaseModel>>() {
            @Override
            public void onResponse(Call<List<AdsBaseModel>> call, Response<List<AdsBaseModel>> response) {
                rvResults.setVisibility(View.VISIBLE);
                pbAds.setVisibility(View.GONE);
                List<AdsBaseModel> adsList = response.body();
                ads.addAll(adsList.get(0).getAds());
                adsAdapter.notifyItemRangeInserted(adsAdapter.getItemCount(), ads.size() - 1);
            }

            @Override
            public void onFailure(Call<List<AdsBaseModel>> call, Throwable t) {
                rvResults.setVisibility(View.VISIBLE);
                pbAds.setVisibility(View.GONE);
                Toast.makeText(getContext(), "no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }


}