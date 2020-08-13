package Library.view;

import Library.model.Item;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableRowData
{

  private StringProperty searchedItem;

  public TableRowData(Item item)
  {
    this.searchedItem = new SimpleStringProperty(item.toString());
  }

  public StringProperty getSearchedItem()
  {
    return searchedItem;
  }
}