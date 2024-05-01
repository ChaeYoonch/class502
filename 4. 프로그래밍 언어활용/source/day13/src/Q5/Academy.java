package Q5;

public class Academy {
    private static Q5.Academy instance = new Q5.Academy();

    private Academy() {}

    public static Q5.Academy getInstance() {
        if (instance == null) {
            instance = new Q5.Academy();
        }
        return instance;
    }
}
