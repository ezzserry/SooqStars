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
import myapplications.serry.sooqstars.adapters.AdsAdapter;
import myapplications.serry.sooqstars.adapters.MessagesAdapter;
import myapplications.serry.sooqstars.apis.GetMessages;
import myapplications.serry.sooqstars.apis.GetSooqAds;
import myapplications.serry.sooqstars.basemodels.AdsBaseModel;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import myapplications.serry.sooqstars.models.Message;
import myapplications.serry.sooqstars.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by awstreams on 8/1/17.
 */

public class MessagesFragment extends Fragment {
    @BindView(R.id.rv_results)
    RecyclerView rvResults;
    @BindView(R.id.pb_results)
    ProgressBar pbResults;
    private MessagesAdapter messagesAdapter;
    private LinearLayoutManager layoutManager;
    private List<Message> messageList;
    private View view;
    private SharedPreferences sharedPreferences;

    public static synchronized MessagesFragment newInstance() {
        return new MessagesFragment();
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
        getMessages();
    }

    private void getMessages() {

        GetMessages getMessages = Utils.newInstance().getRetrofit().create(GetMessages.class);
        Call<List<Message>> adsBaseModelCall = getMessages.getMessages(sharedPreferences.getString(Constants.User_Token, ""));
        adsBaseModelCall.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                pbResults.setVisibility(View.GONE);
                try {
                    List<Message> messages = response.body();
                    if (messages.size() != 0 && messages != null) {
                        messageList.addAll(messages);
                        messagesAdapter.notifyItemRangeInserted(messagesAdapter.getItemCount(), messageList.size() - 1);
                    } else
                        Toast.makeText(getActivity(), "no messages found", Toast.LENGTH_LONG).show();

                } catch (NullPointerException e) {
                    Toast.makeText(getActivity(), "no messages found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                pbResults.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        messageList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        rvResults.setLayoutManager(layoutManager);
        rvResults.setItemAnimator(new DefaultItemAnimator());
        messagesAdapter = new MessagesAdapter(getActivity(), messageList);
        rvResults.setAdapter(messagesAdapter);
        sharedPreferences = getActivity().getSharedPreferences(Constants.MyPrefs, 0);
    }
}
