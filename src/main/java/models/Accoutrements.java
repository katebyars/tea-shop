package models;


public class Accoutrements extends ItemsAll{

    private String type;
    private String maker;

    public Accoutrements(String name, Double price, String image, String type, String maker){
        super(name, price, image);
        this.type = type;
        this.maker = maker;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
