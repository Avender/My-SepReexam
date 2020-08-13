package Library.view;

import Library.model.Book;
import Library.model.Item;
import Library.model.ILibraryItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.IOException;

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
  private ILibraryItem bookModel;
  private Item item;

  public AddBookViewController() {
  }

  public void init(ViewHandler viewHandler, ILibraryItem model, Region root) {
    this.viewHandler = viewHandler;
    this.bookModel = model;
    this.root = root;
  }

  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(ILibraryItem model){
    this.bookModel = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("main");
  }

  @FXML
  public void addButtonPressed() throws IOException {
    Item item = new Book("book", title.getText(), Integer.parseInt(id.getText()), isbn.getText(), author.getText());
    bookModel.addItem(item);
    title.clear();
    author.clear();
    id.clear();
    isbn.clear();
  }
}
