package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class Temp {

    @SerializedName("value")
    private Integer value;
    @SerializedName("unit")
    private String unit;

    public Temp() {
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
