package michal.beers.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Beer {

    private String name;
    private String description;
    @SerializedName("image_url")
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
