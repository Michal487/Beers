package michal.beers.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredients {

    @SerializedName("malt")
    private List<Malt> malt = null;
    @SerializedName("hops")
    private List<Hop> hops = null;
    @SerializedName("yeast")
    private String yeast;

    public Ingredients() {
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    public List<Hop> getHops() {
        return hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}
