public record Member(String memberName, int memberNumber) {

    @Override
    public String toString() {
        return String.format("\n%s (Lånenummer: %d)", memberName, memberNumber);
    }
}
