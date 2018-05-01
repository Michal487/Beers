package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("image_url")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
