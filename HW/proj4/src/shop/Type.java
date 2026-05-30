package shop;

// Custom guitar types
public enum Type {
    ACOUSTIC("Acoustic"),
    ELECTRIC("Electric"),
    CLASSICAL("Classical");

    private final String easyName;

    // Change to easyName
    private Type(String easyName) {
        this.easyName = easyName;
    }

    @Override
    public String toString() {
        return easyName;
    }

}
