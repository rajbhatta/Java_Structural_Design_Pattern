package example.one.problem;

public class Letter {

    private String value;

    public Letter(String value) {

        this.value = value;
        System.out.println("New letter created with value: \t"+value);
    }

    public String getValue() {
        return value;
    }
}
