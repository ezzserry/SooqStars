package myapplications.serry.sooqstars.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import myapplications.serry.sooqstars.models.Message;

/**
 * Created by awstreams on 8/8/17.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
    List<Message> messageList;
    Context context;

    public MessagesAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        MessagesAdapter.MessageViewHolder messageViewHolder = new MessagesAdapter.MessageViewHolder(view);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message messageItem = messageList.get(position);
        holder.tvBody.setText(messageItem.getBody());
        holder.tvUsername.setText(messageItem.getSenderName());
        holder.tvTimer.setText(messageItem.getTimeAgo());
        holder.tvTitle.setText(messageItem.getTitle());

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_body)
        TextView tvBody;
        @BindView(R.id.tv_timer)
        TextView tvTimer;
        @BindView(R.id.ib_delete)
        ImageButton ibDelete;

        public MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tvUsername.setTypeface(Constants.getTypeFace(context));
            tvBody.setTypeface(Constants.getTypeFace(context));
            tvTimer.setTypeface(Constants.getTypeFace(context));
            tvTitle.setTypeface(Constants.getTypeFace(context));
        }
    }
}
