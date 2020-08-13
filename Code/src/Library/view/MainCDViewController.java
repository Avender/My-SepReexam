package Library.view;

import Library.model.Article;
import Library.model.CD;
import Library.model.Item;
import Library.model.LibraryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainCDViewController implements Initializable
{
  @FXML private Button booksButton;
  @FXML private Button articlesButton;
  @FXML private Button CDButton;
  @FXML private Button borrowButton;
  @FXML private Button returnButton;
  @FXML private Button addButton;
  @FXML private TextField searchField;
  @FXML private Button searchButton;
  @FXML private TableView<Item> itemTable;
  @FXML private TextField totalField;
  @FXML private TextField availableField;
  @FXML private TextField borrowedField;
  @FXML private TableColumn<Item, String> titleColumn;
  @FXML private TableColumn<Item, Integer> IDColumn;
  @FXML private TableColumn<Item, Boolean> borrowedColumn;
  private final ObservableList<Item> dataList = FXCollections.observableArrayList ();

  private Region root;
  private ViewHandler viewHandler;
  private LibraryModel mainModel;
  private Item item;

  public MainCDViewController() {
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
  public void booksButtonPressed(){
    viewHandler.openView("main");
  }

  @FXML
  public void articlesButtonPressed(){
    viewHandler.openView("mainArticle");
  }

  @FXML
  public void CDButtonPressed(){
    viewHandler.openView("mainCD");
  }

  @FXML
  public void borrowButtonPressed(){
    viewHandler.openView("borrow");
  }

  @FXML
  public void addButtonPressed(){
    viewHandler.openView("addCD");
  }

  @FXML
  public void returnButtonPressed(ActionEvent actionEvent) throws FileNotFoundException
  {
    mainModel.returnItem(item);
    viewHandler.closeView();
  }

  public void loadList(){
    ObservableList<Item> items = FXCollections.observableArrayList ();
    items.addAll (items);
    itemTable.setItems (items);
    itemTable.getSelectionModel ().selectFirst ();
    itemTable.setItems (items);
  }
  @Override
  public void initialize (URL url, ResourceBundle resourceBundle) {
    titleColumn.setCellValueFactory (new PropertyValueFactory<Item,String> ("Title"));
    IDColumn.setCellValueFactory (new PropertyValueFactory<Item,Integer> ("ID"));
    borrowedColumn.setCellValueFactory (new PropertyValueFactory<Item,Boolean> ("Borrowed"));
    loadList ();
    Item item1 = new CD ("CD","Titanic",20);
    Item item2 = new CD ("CD","Backyardigans",21);
    Item item3 = new CD ("CD","Pulp Fiction",22);
    dataList.addAll(item1,item2, item3);
    //Wrap the Observable List in a filtered list(initially display all data)
    FilteredList<Item> filteredList = new FilteredList<> (dataList, b -> true);
    //Set the filter predicate whenever the filter changes
    searchField.textProperty ().addListener ((observable, oldValue, newValue) -> {
      filteredList.setPredicate (item -> {
        //if filter text is empty, display all items
        if (newValue == null || newValue.isEmpty ()) {
          return true;
        }
        String loweCaseFilter = newValue.toLowerCase ();
        if (item.getTitle ().toLowerCase ().indexOf (loweCaseFilter) != -1) {
          return true; //Filter matches the title
        } else if (item.getType ().toLowerCase ().indexOf (loweCaseFilter) != -1) {
          return true;//Filter matches the ID
        } else if (String.valueOf (item.getID ()).indexOf (loweCaseFilter) != -1)
          return true;
        else
          return false;//Does not match
      });
    });
    //Wrap the FilteredList in a sortedList
    SortedList<Item> sortedList = new SortedList<> (filteredList);
    //Bind the sortedlist comparator to the tableview comparator
    sortedList.comparatorProperty ().bind (itemTable.comparatorProperty ());
    //Add sorted data to the table
    itemTable.setItems (sortedList);
  }
}