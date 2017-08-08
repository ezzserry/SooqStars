package myapplications.serry.sooqstars.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Ad;

/**
 * Created by awstreams on 8/3/17.
 */

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdViewHolder> {

    List<Ad> adsList;
    Context context;

    public AdsAdapter(Context context, List<Ad> adsList) {
        this.context = context;
        this.adsList = adsList;
    }

    @Override
    public AdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        AdViewHolder adViewHolder = new AdViewHolder(view);
        return adViewHolder;
    }

    @Override
    public void onBindViewHolder(AdViewHolder holder, int position) {
        Ad adItem = adsList.get(position);
        holder.tvTitle.setText(adItem.getTitle());
        holder.tvAdvertiserName.setText(adItem.getOwner());
        holder.tvTimeAgo.setText(adItem.getTimeAgo());
        holder.tvComments.setText(adItem.getComments());
        holder.tvLikes.setText(adItem.getNumOfLikes());
        holder.tvLocation.setText(adItem.getCity());
        Glide.with(context).load(adItem.getImageURL()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(holder.ivAdPhoto);
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvTitle;
        @BindView(R.id.tv_advertiser_name)
        TextView tvAdvertiserName;
        @BindView(R.id.iv_ad)
        ImageView ivAdPhoto;
        @BindView(R.id.tv_comments_count)
        TextView tvComments;
        @BindView(R.id.tv_likes_count)
        TextView tvLikes;
        @BindView(R.id.tv_timer)
        TextView tvTimeAgo;
        @BindView(R.id.tv_location)
        TextView tvLocation;


        public AdViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tvTitle.setTypeface(Constants.getTypeFace(context));
            tvAdvertiserName.setTypeface(Constants.getTypeFace(context));
            tvComments.setTypeface(Constants.getTypeFace(context));
            tvLikes.setTypeface(Constants.getTypeFace(context));
            tvTimeAgo.setTypeface(Constants.getTypeFace(context));
            tvLocation.setTypeface(Constants.getTypeFace(context));
        }
    }
}
