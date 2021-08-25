package holoLib;

public interface Payment {
    float payBorrow(float payment, float balance);
}

/*
        if (balance < payment) {
            System.out.println("Insuffient balance. Please top up the balance before borrowing the book.");
            return balance;
        }
        else {
            System.out.println("Your borrow payment has been paid");
            return balance - payment;
        }
*/