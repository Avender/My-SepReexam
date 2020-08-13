package Library.model;

import java.util.Date;

public class Borrower {
    private String name;
    private int CPR;
    private String type;
    private Date borrowDate;
    private Date returnDate;


    public Borrower (String name, int cpr, String type, Date borrowDate, Date returnDate) {
        this.name = name;
        this.CPR = cpr;
        this.type = type;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getName () {
        return name;
    }

    public String getType () {
        return type;
    }

    public Date getBorrowDate () {
        return borrowDate;
    }

    public Date getReturnDate () {
        return returnDate;
    }

    public int getCPR () {
        return CPR;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setBorrowDate (Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setCPR (int CPR) {
        this.CPR = CPR;
    }

    public void setReturnDate (Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setType (String type) {
        this.type = type;
    }
}
