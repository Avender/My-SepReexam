package Library.model;

public class Article extends Item {
    private String author;
    private String magazine;
    public Article (String type, String title, int ID, String author, String magazine) {
        super (type, title, ID);
        this.author = author;
        this.magazine = magazine;
    }

    @Override
    public String getType () {
        return "Article";
    }
}
