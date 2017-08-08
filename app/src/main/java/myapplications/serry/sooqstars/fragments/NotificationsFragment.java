package myapplications.serry.sooqstars.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.adapters.NotificationsAdapter;
import myapplications.serry.sooqstars.apis.GetNotifications;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import myapplications.serry.sooqstars.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by awstreams on 8/1/17.
 */

public class NotificationsFragment extends Fragment {
    @BindView(R.id.rv_results)
    RecyclerView rvResults;
    @BindView(R.id.pb_results)
    ProgressBar pbResults;
    private Retrofit retrofit;
    private NotificationsAdapter notificationsAdapter;
    private LinearLayoutManager layoutManager;
    private List<Notification> notificationList;
    private View view;
    private SharedPreferences sharedPreferences;

    public static synchronized NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        getNotifications();
    }

    private void initViews() {
        notificationList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        rvResults.setLayoutManager(layoutManager);
        rvResults.setItemAnimator(new DefaultItemAnimator());
        notificationsAdapter = new NotificationsAdapter(getActivity(), notificationList);
        rvResults.setAdapter(notificationsAdapter);
        sharedPreferences = getActivity().getSharedPreferences(Constants.MyPrefs, 0);
    }

    private void getNotifications() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.newInstance().getClient(getActivity()))
                .build();
        GetNotifications getNotifications = retrofit.create(GetNotifications.class);
        Call<List<Notification>> adsBaseModelCall = getNotifications.getNotifications("4");
        adsBaseModelCall.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                pbResults.setVisibility(View.GONE);
                List<Notification> notifications = response.body();
                if (notifications.size() != 0) {
                    notificationList.addAll(notifications);
                    notificationsAdapter.notifyItemRangeInserted(notificationsAdapter.getItemCount(), notificationList.size() - 1);
                } else
                    Toast.makeText(getActivity(), "no notifications found", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                pbResults.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }
}
