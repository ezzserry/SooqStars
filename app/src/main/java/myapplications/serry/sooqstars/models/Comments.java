package myapplications.serry.sooqstars.models;

/**
 * Created by awstreams on 8/20/17.
 */

public class Comments {
    String SenderName;
    String TimeAgo;
    String ImageURL;
    String Id;
    String Comment;
    String AdId;
    String IsRead;
    String ReplyText;
    String CreatedDate;
    String UserId;
    String IsActive;

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    public String getTimeAgo() {
        return TimeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        TimeAgo = timeAgo;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getAdId() {
        return AdId;
    }

    public void setAdId(String adId) {
        AdId = adId;
    }

    public String getIsRead() {
        return IsRead;
    }

    public void setIsRead(String isRead) {
        IsRead = isRead;
    }

    public String getReplyText() {
        return ReplyText;
    }

    public void setReplyText(String replyText) {
        ReplyText = replyText;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }
}
