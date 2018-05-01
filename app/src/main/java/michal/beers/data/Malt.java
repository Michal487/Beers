package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class Malt {

    @SerializedName("name")
    private String name;
    @SerializedName("amount")
    private Amount amount;

    public Malt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
