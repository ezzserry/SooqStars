package myapplications.serry.sooqstars.models;

import java.util.List;

/**
 * Created by LENOVO on 10/08/2017.
 */

public class Category {
    String Id;
    String Name;
    String IsActive;
    String TypeId;
    String ParentId;
    String ImageURL;
    String CreatedDate;
    List<Category> SubCategories;
    List<Features> Features;

    public Category(String id, String name, String isActive, String typeId, String parentId, String imageURL, String createdDate,
                    List<Category>  subCategories, List<myapplications.serry.sooqstars.models.Features> features) {
        Id = id;
        Name = name;
        IsActive = isActive;
        TypeId = typeId;
        ParentId = parentId;
        ImageURL = imageURL;
        CreatedDate = createdDate;
        SubCategories = subCategories;
        Features = features;
    }

    public Category() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getTypeId() {
        return TypeId;
    }

    public void setTypeId(String typeId) {
        TypeId = typeId;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public  List<Category>  getSubCategories() {
        return SubCategories;
    }

    public void setSubCategories( List<Category>  subCategories) {
        SubCategories = subCategories;
    }

    public List<myapplications.serry.sooqstars.models.Features> getFeatures() {
        return Features;
    }

    public void setFeatures(List<myapplications.serry.sooqstars.models.Features> features) {
        Features = features;
    }
}
