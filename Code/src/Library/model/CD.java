package Library.model;

public class CD extends Item {

    public CD (String type, String title, int ID) {
        super (type, title, ID);
    }

    @Override
    public String getType () {
        return "CD";
    }
}
