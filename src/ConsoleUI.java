import java.lang.classfile.constantpool.LoadableConstantEntry;
import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg: "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowBook() {
        int memberNumber = Integer.parseInt(IO.readln("Indtast lånenummer: "));
        int bookId = Integer.parseInt(IO.readln("Indtast bogid: "));
        boolean loan = library.loanBook(memberNumber, bookId);
        if (loan) {
            IO.println("Lån registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast bogid: "));
        boolean returnBook = library.returnBook(bookId);
        if (returnBook) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast lånenummer: "));
        ArrayList<Loan> find = library.findLoansByMemberId(memberId);
        if (find.isEmpty()) {
            IO.println("Ingen udlån");
        } else {
            for (Loan loan : find) {
                IO.println(find);
            }
        }
    }
}

