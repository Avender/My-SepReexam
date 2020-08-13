package Library.model;

public class Book extends Item {
    private String ISBN;
    private String author;
    public Book (String type, String title, int ID, String ISBN, String author) {
        super (type, title, ID);
        this.ISBN = ISBN;
        this.author = author;
    }

    @Override
    public String getType() {
        return "Book";
    }
}
