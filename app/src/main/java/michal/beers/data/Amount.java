package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class Amount {

    @SerializedName("value")
    private Double value;
    @SerializedName("unit")
    private String unit;

    public Amount() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
