package michal.beers.data;

import com.google.gson.annotations.SerializedName;

public class Hop {

    @SerializedName("name")
    private String name;
    @SerializedName("amount")
    private Amount amount;
    @SerializedName("add")
    private String add;
    @SerializedName("attribute")
    private String attribute;

    public Hop() {
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
