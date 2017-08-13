package myapplications.serry.sooqstars.models;

/**
 * Created by LENOVO on 10/08/2017.
 */

public class Features {
    String Values;
    String Id;
    String Name;
    String CategoryId;
    String IsActive;

    public Features() {
    }

    public Features(String values, String id, String name, String categoryId, String isActive) {
        Values = values;
        Id = id;
        Name = name;
        CategoryId = categoryId;
        IsActive = isActive;
    }

    public String getValues() {
        return Values;
    }

    public void setValues(String values) {
        Values = values;
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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }
}
