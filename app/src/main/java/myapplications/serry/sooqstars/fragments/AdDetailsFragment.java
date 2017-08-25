package myapplications.serry.sooqstars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.apis.GetAdDetails;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.helpers.Utils;
import myapplications.serry.sooqstars.models.Ad;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.tv_advertiser_name)
    TextView tvAdvertiseName;
    @BindView(R.id.tv_timer)
    TextView tvTime;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_ad_title)
    TextView tvAdTitle;
    @BindView(R.id.tv_likes_count)
    TextView tvLikes;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.iv_user_photo)
    ImageView ivUser;
    @BindView(R.id.ll_images_container)
    LinearLayout llImages;

    private View view;
    private String AdId;
    @BindView(R.id.pb_results)
    ProgressBar pbResults;
    @BindView(R.id.sv_details_container)
    ScrollView svDetails;

    public AdDetailsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AdDetailsFragment newInstance(String adId) {
        AdDetailsFragment fragment = new AdDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, adId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            AdId = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_post_details, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(AdId);
    }

    private void initViews(String ID) {
        GetAdDetails getAdDetails = Utils.newInstance().getRetrofit().create(GetAdDetails.class);
        Call<List<Ad>> listCall = getAdDetails.getAdDetails(ID);
        listCall.enqueue(new Callback<List<Ad>>() {
            @Override
            public void onResponse(Call<List<Ad>> call, Response<List<Ad>> response) {
                setDetails(response.body().get(0));
                svDetails.setVisibility(View.VISIBLE);
                pbResults.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Ad>> call, Throwable t) {
                pbResults.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "no internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setDetails(Ad ad) {
        tvAdTitle.setText(ad.getTitle());
        tvAdTitle.setTypeface(Constants.getTypeFace(getActivity()));

        tvAdvertiseName.setText(ad.getOwner());
        tvAdvertiseName.setTypeface(Constants.getTypeFace(getActivity()));

        if (ad.getTimeAgo() != null) {
            tvTime.setText(ad.getTimeAgo());
            tvTime.setTypeface(Constants.getTypeFace(getActivity()));
        }
        if (ad.getCity() != null) {
            tvLocation.setText(ad.getCity());
            tvLocation.setTypeface(Constants.getTypeFace(getActivity()));
        }
        if (ad.getDescription() != null) {
            tvDescription.setText(ad.getDescription());
            tvDescription.setTypeface(Constants.getTypeFace(getActivity()));
        }
        if (ad.getNumOfLikes() != null) {
            tvLikes.setText(ad.getNumOfLikes());
            tvLikes.setTypeface(Constants.getTypeFace(getActivity()));
        }
        Glide.with(getActivity()).load(ad.getPhoto()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                ivUser.setImageResource(R.drawable.bg_default_pic);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(ivUser);

        if (ad.getImages() != null || ad.getImages().size() != 0) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 5, 5, 5);
            for (int i = 0; i < ad.getImages().size(); i++) {
                ImageView imageView = new ImageView(getActivity());
                imageView.setLayoutParams(params);
                Glide.with(getActivity())
                        .load(ad.getImages().get(i).getURL())
                        .into(imageView);
                llImages.addView(imageView);
            }
        }
    }


}
