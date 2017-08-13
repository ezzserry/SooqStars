package myapplications.serry.sooqstars.models;

/**
 * Created by LENOVO on 10/08/2017.
 */

public class FeatureValue {
    String CategoryId;
    String Id;
    String Name;
    String FeatureId;

    public FeatureValue() {
    }

    public FeatureValue(String categoryId, String id, String name, String featureId) {
        CategoryId = categoryId;
        Id = id;
        Name = name;
        FeatureId = featureId;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
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

    public String getFeatureId() {
        return FeatureId;
    }

    public void setFeatureId(String featureId) {
        FeatureId = featureId;
    }
}
