package myapplications.serry.sooqstars.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myapplications.serry.sooqstars.R;
import myapplications.serry.sooqstars.helpers.Constants;
import myapplications.serry.sooqstars.models.Message;
import myapplications.serry.sooqstars.models.Notification;

/**
 * Created by awstreams on 8/8/17.
 */

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder> {
    List<Notification> notificationList;
    Context context;

    public NotificationsAdapter(Context context, List<Notification> notificationList) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        NotificationsAdapter.NotificationViewHolder notificationViewHolder = new NotificationsAdapter.NotificationViewHolder(view);
        return notificationViewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        Notification notification = notificationList.get(position);
        holder.tvBody.setText(notification.getBody());
        holder.tvTimer.setText(notification.getCreatedDate());
        holder.tvTitle.setText(notification.getTitle());

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_timer)
        TextView tvTimer;
        @BindView(R.id.ib_delete)
        ImageButton ibDelete;
        @BindView(R.id.tv_body)
        TextView tvBody;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tvTimer.setTypeface(Constants.getTypeFace(context));
            tvBody.setTypeface(Constants.getTypeFace(context));
            tvTitle.setTypeface(Constants.getTypeFace(context));


        }
    }
}
