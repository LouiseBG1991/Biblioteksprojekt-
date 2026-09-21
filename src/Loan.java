import java.time.LocalDate;
// Holder styr på et lån (bog,låner, lånerdato)
public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate borrowedDate;

    // Konstruktør, der opretter et nyt låneobjekt
    public Loan (Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;

    }

    //Getter: returnerer den bog, der bliver lånt
    public Book getBook () {
        return book;
    }

    //Getter: returnerer den låner, der låner bogen
    public Member getMember() {
        return member;
    }

    // Getter: returnerer, hvornår bogen skal afleveres
    public LocalDate getDueDate () {
        return borrowedDate.plusDays(14);
    }

    //Tjekker om lånet er overskredet
    public boolean isOverdue () {
        return LocalDate.now().isAfter(getDueDate());
    }

    //Information om lånet
    @Override
    public String toString () {
        String status = isOverdue() ? "Overskredet" : "Ikke overskredet";
        return String.format("%s %s \nAfleveringsfrist: " + getDueDate() + "\nStatus: %s", book, member, status);
    }
}

