package app.model;

public class Item {

    public Item(String description){
        this.description = description;
    }

    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
