import java.time.LocalDate;
import java.util.ArrayList;

//Lister, der holder styr på bibliotekets bøger, lånere og udlån
public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

//Konstruktør, som initialiserer listerne
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    //Tilføjer bog til biblioteket
    public void addBook(Book book) {
        books.add(book);
    }
    // Tilføjer låner til biblioteket
    public void addMember(Member member) {
        members.add(member);
    }

    //Getter: returnerer listen over alle aktive udlån
    public ArrayList<Loan> getLoan() {
        return loans;
    }
    //Getter: returnerer listen over alle bøger
    public ArrayList<Book> getBook() {
        return books;
    }

    //Getter returnerer listen over alle lånere
    public ArrayList<Member> getMember() {
        return members;
    }

    //Udskriver alle bibliotekets bøger
    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    // Udskriver alle bibliotekets lånere
    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }

    //Getter: finder og returnerer en bestemt bog på baggrund af ID
    public Book getBook (int bookId) {
        for (Book book : books)
            if (book.ID() == bookId) {
                return book;

        }
        return null; // eller null, hvis bogen ikke findes
    }

    //Getter: finder og returnerer en bestemt låner på baggrund af lånernummer
    public Member getMember (int memberId) {
        for (Member member : members)
            if (member.memberNumber() == memberId) {
                return member;
            }
        return null; // eller null, låneren ikke findes
    }

    // Udlåner en bog, hvis både låner og bog findes og opretter et nyt lån
    public boolean loanBook (int memberId, int bookId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);

        if (member == null || book == null) {
            return false;
        }
        for (Loan loan : loans) {
            if (loan.getBook().ID() == bookId) {
                return false;
            }
        }

        Loan newLoan = new Loan(book, member, LocalDate.now());
        loans.add(newLoan);
        return true;
    }

    // Afleverer en bog tilbage ved at fjerne et lån fra listen på baggrund af ID
    public boolean returnBook (int bookId) {
        for (int i = 0; i<loans.size(); i++) {
            Loan loan = loans.get(i);
            if (loan.getBook().ID() == bookId) {
                loans.remove(i);
                return true;
            }
        }
        return false;
    }

    // Finder og returnerer en liste over alle lån en bestemt låner har
    public ArrayList<Loan> findLoansByMemberId (int memberId) {
        ArrayList<Loan> find = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().memberNumber() == memberId) {
                find.add(loan);
            }
        }
        return find;
    }

    public String toString() {
        return "Bibliotek \nAntal bøger: " + books.size() + "\nAntal lånere: " + members.size();
    }
}
