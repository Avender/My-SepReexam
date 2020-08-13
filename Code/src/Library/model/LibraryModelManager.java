package Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LibraryModelManager implements LibraryModel, BySave, CSVSave
{
    private ArrayList<Item> availableItems;
    private ArrayList<Item> reservedItems;
    private File availableFile;
    private File reservedFile;
    private Borrower borrower;

    public LibraryModelManager(){
      availableItems = new ArrayList<Item>();
      String availableFileName = "availableItems.txt";
      File availableFile = new File (availableFileName);

      reservedItems = new ArrayList<Item>();
      String reservedFileName = "reservedItems.txt";
      File reservedFile = new File (reservedFileName);
    }

    @Override
    public void addItem (Item item) throws FileNotFoundException {
        PrintWriter out = new PrintWriter (availableFile);
        availableItems.add(item);
        for (int i = 0; i < availableItems.size (); i++){
            out.println (availableItems.get(i));
            out.flush();
        }
        out.close();
    }

    @Override
    public void borrowItem (Item item) throws FileNotFoundException
    {
      PrintWriter outAv = new PrintWriter(availableFile);
      availableItems.remove(item);
      for (int i = 0; i < availableItems.size(); i++)
      {
        outAv.println(availableItems.get(i));
        availableItems.remove(item);
        outAv.flush();
      }
      PrintWriter outRe = new PrintWriter(reservedFile);
      reservedItems.add(item);
      outRe.flush();
    }

    @Override
    public void returnItem (Item item) throws FileNotFoundException
    {
      PrintWriter outRe = new PrintWriter(reservedFile);
      reservedItems.remove(item);
      for (int i = 0; i < reservedItems.size(); i++)
      {
        outRe.println(reservedItems.get(i));
        reservedItems.remove(item);
        outRe.flush();
      }
      PrintWriter outAv = new PrintWriter(availableFile);
      availableItems.add(item);
      outAv.flush();
    }

  public ArrayList<Item> getAvailableItems()
  {
    return availableItems;
  }

  public void setAvailableItems(ArrayList<Item> availableItems)
  {
    this.availableItems = availableItems;
  }

  public ArrayList<Item> getReservedItems()
  {
    return reservedItems;
  }

  public void setReservedItems(ArrayList<Item> reservedItems)
  {
    this.reservedItems = reservedItems;
  }

  public File getAvailableFile()
  {
    return availableFile;
  }

  public void setAvailableFile(File availableFile)
  {
    this.availableFile = availableFile;
  }

  public File getReservedFile()
  {
    return reservedFile;
  }

  public void setReservedFile(File reservedFile)
  {
    this.reservedFile = reservedFile;
  }

  public Borrower getBorrower()
  {
    return borrower;
  }

  public void setBorrower(Borrower borrower)
  {
    this.borrower = borrower;
  }

  @Override
    public void saveToCSV () {
        String StringCSV[] = new String[availableItems.size () + 1];
        StringCSV[0]="ID,Item,type";
        for(int i = 0;i <availableItems.size (); i++){
            StringCSV[i+1] = availableItems.get (i).toString ();
        }
        try{
            CSVSave.CSVSave ("table.csv",StringCSV);
        }
        catch (Exception e){
            System.out.println ("ERROR CANNOT WRITE THE FILE");
            return;
        }
    }
}

