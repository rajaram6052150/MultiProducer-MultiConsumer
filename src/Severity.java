public enum Severity {
    Emergency(0),
    Alert(1),
    Critical(2),
    Error(3),
    Warning(4),
    Notice(5),
    Informational(6),
    Debugging(7);

    private int value;

    Severity(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
