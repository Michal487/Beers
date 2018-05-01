package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class BoilVolume {

    @SerializedName("value")
    private Integer value;
    @SerializedName("unit")
    private String unit;

    public BoilVolume() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
