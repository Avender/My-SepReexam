package Library.view;

import Library.model.Item;
import Library.model.ILibraryBooks;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class AddArticleViewController
{
  @FXML
  private TextField title;

  @FXML
  private TextField author;

  @FXML
  private TextField id;

  @FXML
  private TextField magazine;

  @FXML
  private Button backButton;

  @FXML
  private Button addButton;

  private Region root;
  private ViewHandler viewHandler;
  private ILibraryBooks mainModel;
  private Item item;

  public AddArticleViewController() {
  }

  public void init(ViewHandler viewHandler, ILibraryBooks model, Region root) {
    this.viewHandler = viewHandler;
    this.mainModel = model;
    this.root = root;
  }

  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(ILibraryBooks model){
    this.mainModel = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("mainArticle");
  }

  @FXML
  public void addButtonPressed() throws FileNotFoundException {
    viewHandler.closeView();
  }
}
