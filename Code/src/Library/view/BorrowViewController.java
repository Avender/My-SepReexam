package Library.view;

import Library.model.Item;
import Library.model.LibraryModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;

public class BorrowViewController
{
  @FXML
  private TextField nameField;

  @FXML
  private TextField CPRField;

  @FXML
  private TextField typeField;

  @FXML
  private TextField itemIDField;

  @FXML
  private TextField borrowDateField;

  @FXML
  private TextField returnDateField;

  @FXML
  private Button backButton;

  @FXML
  private Button borrowButton;

  private Region root;
  private ViewHandler viewHandler;
  private LibraryModel mainModel;
  private Item item;

  public BorrowViewController() {
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

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("main");
  }

  public void borrowButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
  {
    mainModel.borrowItem(item);
    viewHandler.closeView();
  }
}
