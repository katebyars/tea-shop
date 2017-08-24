package models;


public class ItemsAll {
    private String name;
    private Double price;
    private String image;
    int id;

    public ItemsAll(String name, Double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsAll itemsAll = (ItemsAll) o;

        if (id != itemsAll.id) return false;
        if (!name.equals(itemsAll.name)) return false;
        if (!price.equals(itemsAll.price)) return false;
        return image.equals(itemsAll.image);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + image.hashCode();
        result = 31 * result + id;
        return result;
    }
}
