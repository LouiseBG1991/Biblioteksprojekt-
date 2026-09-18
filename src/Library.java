import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Loan> getLoan() {
        return loans;
    }

    public ArrayList<Book> getBook() {
        return books;
    }

    public ArrayList<Member> getMember() {
        return members;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }

    public Book getBook (int bookId) {
        for (Book book : books)
            if (book.ID() == bookId) {
                return book;

        }
        return null;
    }

    public Member getMember (int memberId) {
        for (Member member : members)
            if (member.memberNumber() == memberId) {
                return member;
            }
        return null;
    }

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
