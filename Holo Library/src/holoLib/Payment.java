package holoLib;

public class Payment {
    
    // Pay the money of borrowing books,  returning the balance
    // For the code outside, if balance returned is same as the balance before -> Insuffient balance, need to top up
    public float payBorrow(float payment, float balance){
        if (balance < payment) {
            System.out.println("Insuffient balance. Please top up the balance before borrowing the book.");
            return balance;
        }
        else {
            System.out.println("Your borrow payment has been paid");
            return balance - payment;
        }
    }

    // reload, renew membership card
    // public float ??

    // Pay penalty
    // public float ??
}
