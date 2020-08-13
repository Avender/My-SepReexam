package Library.model;

public abstract class Item {
    private String title;
    private int ID;
    private String type;
    private boolean isBorrowed;
    public Item(String type, String title, int ID){
        this.type = type;
        this.title = title;
        this.ID = ID;
        isBorrowed = false;
    }

    public abstract String getType();

    public String getTitle()
    {
        return title;
    }

    public int getID()
    {
        return ID;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isBorrowed()
    {
        return isBorrowed;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", ID=" + ID +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
