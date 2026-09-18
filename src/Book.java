public record Book(String NAME, String TITLE, String ISBN, int ID) {

    @Override
    public String toString() {
        return String.format("%s: %s; %s; (%d).", NAME, TITLE, ISBN, ID);
    }
}
