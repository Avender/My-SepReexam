package Library.view;

import Library.model.Item;
import Library.model.LibraryModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class AddCDViewController
{
  @FXML
  private TextField title;

  @FXML
  private TextField id;

  @FXML
  private Button backButton;

  @FXML
  private Button addButton;

  private Region root;
  private ViewHandler viewHandler;
  private LibraryModel mainModel;
  private Item item;

  public AddCDViewController() {
  }

  public void init(ViewHandler viewHandler, LibraryModel model, Region root) {
    this.viewHandler = viewHandler;
    this.mainModel = model;
    this.root = root;
  }

  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(LibraryModel model){
    this.mainModel = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("mainCD");
  }

  @FXML
  public void addButtonPressed() throws FileNotFoundException
  {
    mainModel.addItem(item);
    viewHandler.closeView();
  }
}