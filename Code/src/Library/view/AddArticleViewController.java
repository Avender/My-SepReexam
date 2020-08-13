package Library.view;

import Library.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.IOException;

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
  private ILibraryItem libraryItem;
  private Item item;

  public AddArticleViewController() {
  }

  public void init(ViewHandler viewHandler, ILibraryItem model, Region root) {
    this.viewHandler = viewHandler;
    this.libraryItem = model;
    this.root = root;
  }


  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(ILibraryItem model){
    this.libraryItem = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("mainArticle");
  }

  @FXML
  public void addButtonPressed() throws IOException {
    Item item = new Article("article",title.getText(), Integer.parseInt(id.getText()), magazine.getText(), author.getText());
    libraryItem.addItem(item);
    title.clear();
    id.clear();
    magazine.clear();
    author.clear();
   // viewHandler.closeView();
  }
}
