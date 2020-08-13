package Library.view;

import Library.model.CD;
import Library.model.Item;
import Library.model.ILibraryItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

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
  private ILibraryItem mainModel;
  private Item item;

  public AddCDViewController() {
  }

  public void init(ViewHandler viewHandler, ILibraryItem model, Region root) {
    this.viewHandler = viewHandler;
    this.mainModel = model;
    this.root = root;
  }

  public void reset() {
  }

  public Region getRoot() {
    return root;
  }

  public void setModel(ILibraryItem model){
    this.mainModel = model;
  }

  @FXML
  public void backButtonPressed(){
    viewHandler.openView("mainCD");
  }

  @FXML
  public void addButtonPressed() throws IOException {
    if(title.getText().trim().isEmpty() || id.getText().trim().isEmpty() || id.getText().trim().matches(".*\\D.*"))
    {
      JOptionPane.showMessageDialog(null, "You inputted something incorrect. Try once again", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else {
      Item item = new CD("cd", title.getText(), Integer.parseInt(id.getText()));
      mainModel.addItem(item);
      title.clear();
      id.clear();
    }
   // viewHandler.closeView();
  }
}
