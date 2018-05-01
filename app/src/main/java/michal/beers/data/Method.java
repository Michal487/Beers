package michal.beers.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Method {

    @SerializedName("mash_temp")
    private List<MashTemp> mashTemp = null;
    @SerializedName("fermentation")
    private Fermentation fermentation;
    @SerializedName("twist")
    private Object twist;

    public Method() {
    }

    public List<MashTemp> getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(List<MashTemp> mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public Object getTwist() {
        return twist;
    }

    public void setTwist(Object twist) {
        this.twist = twist;
    }
}
