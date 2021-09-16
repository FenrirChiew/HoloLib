package holoLib;

public interface SearchBorrower {
    /********** Methods **********/
    Borrower searchMemberByID(String memberID);

    Borrower searchLibrarianByID(String librarianID);

    Borrower searchBorrowerByID(String borrowerID);

    Borrower searchBorrowerByCardNO(String cardNO);
}
