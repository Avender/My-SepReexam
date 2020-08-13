package Library.model;

public abstract class Item implements BySave{
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

    public boolean isBorrowed()
    {
        return isBorrowed;
    }

}
