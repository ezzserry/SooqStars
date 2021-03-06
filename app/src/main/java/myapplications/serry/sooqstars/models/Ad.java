package myapplications.serry.sooqstars.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by awstreams on 8/3/17.
 */

public class Ad implements Serializable {
    String Id;
    String Title;
    String Description;
    String CategoryId;
    String UserId;
    String CityId;
    String ImageURL;
    String IsFree;
    String IsActive;
    String CreatedDate;
    String UpdatedDate;
    String ExpiryDate;
    String RefId;
    String MapURL;
    String NumOfViews;
    String NumOfLikes;
    String NumOfComments;
    String PhoneNumber;
    String MobileNumber;
    String DeletedData;
    String Owner;
    String City;
    String TimeAgo;
    ArrayList<Images> Images;
    ArrayList<Comments> Comments;
    ArrayList<Tags> Tags;
    String Photo;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getIsFree() {
        return IsFree;
    }

    public void setIsFree(String isFree) {
        IsFree = isFree;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        UpdatedDate = updatedDate;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getRefId() {
        return RefId;
    }

    public void setRefId(String refId) {
        RefId = refId;
    }

    public String getMapURL() {
        return MapURL;
    }

    public void setMapURL(String mapURL) {
        MapURL = mapURL;
    }

    public String getNumOfViews() {
        return NumOfViews;
    }

    public void setNumOfViews(String numOfViews) {
        NumOfViews = numOfViews;
    }

    public String getNumOfLikes() {
        return NumOfLikes;
    }

    public void setNumOfLikes(String numOfLikes) {
        NumOfLikes = numOfLikes;
    }

    public String getNumOfComments() {
        return NumOfComments;
    }

    public void setNumOfComments(String numOfComments) {
        NumOfComments = numOfComments;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getDeletedData() {
        return DeletedData;
    }

    public void setDeletedData(String deletedData) {
        DeletedData = deletedData;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getTimeAgo() {
        return TimeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        TimeAgo = timeAgo;
    }

    public ArrayList<myapplications.serry.sooqstars.models.Images> getImages() {
        return Images;
    }

    public void setImages(ArrayList<myapplications.serry.sooqstars.models.Images> images) {
        Images = images;
    }

    public ArrayList<myapplications.serry.sooqstars.models.Comments> getComments() {
        return Comments;
    }

    public void setComments(ArrayList<myapplications.serry.sooqstars.models.Comments> comments) {
        Comments = comments;
    }

    public ArrayList<myapplications.serry.sooqstars.models.Tags> getTags() {
        return Tags;
    }

    public void setTags(ArrayList<myapplications.serry.sooqstars.models.Tags> tags) {
        Tags = tags;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
