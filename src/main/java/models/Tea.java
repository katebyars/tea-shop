package models;


public class Tea extends ItemsAll {

    private String type;
    private String sourceCountry;


    public Tea (String name, Double price, String image, String type, String sourceCountry){
        super(name, price, image);
        this.type = type;
        this.sourceCountry = sourceCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tea tea = (Tea) o;

        if (!type.equals(tea.type)) return false;
        return sourceCountry.equals(tea.sourceCountry);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + sourceCountry.hashCode();
        return result;
    }
}
