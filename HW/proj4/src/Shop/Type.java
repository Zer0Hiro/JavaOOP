package Shop;

public enum Type {
    ACOUSTIC("Acoustic"),
    ELECTRIC("Electrical"),
    CLASSICAL("Classical");

    private final String easyName;

    private Type(String easyName) {
        this.easyName = easyName;
    }

    @Override
    public String toString() {
        return easyName;
    }

}
