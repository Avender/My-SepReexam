package Library.view;

import Library.model.Book;
import Library.model.Item;
import Library.model.ILibraryBooks;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class AddBookViewController
{
  @FXML
  private TextField title;

  @FXML
  private TextField author;

  @FXML
  private TextField id;

  @FXML
  private TextField isbn;

  @FXML
  private Button backButton;

  @FXML
  private Button addButton;

  private Region root;
  private ViewHandler viewHandler;
  private ILibraryBooks bookModel;
  private Item item;

  public AddBookViewController() {
  }

  public void init(ViewHandler viewHandler, ILibraryBooks model, Region root) {
    this.viewHandler = viewHandler;
    this.bookModel = model;
    this.root = root;
  }

  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(ILibraryBooks model){
    this.bookModel = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("main");
  }

  @FXML
  public void addButtonPressed() throws IOException {
    bookModel.addBook(new Book("book", title.getText(), Integer.parseInt(id.getText()), isbn.getText(), author.getText()));
    title.clear();
    author.clear();
    id.clear();
    isbn.clear();
  }
}
