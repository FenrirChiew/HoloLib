package holoLib;

public interface Payment {
    /********** Methods **********/
    void payPayment(double payment);

    void displayInvoice(Borrower borrower, double payment);
}
