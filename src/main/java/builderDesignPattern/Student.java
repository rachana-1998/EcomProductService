package builderDesignPattern;

import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final String email;
    private final String cources;
    private final int age;
    private final int fee;

    // Private constructor to enforce the use of the builder
   private Student(StudentBuilder builder) {
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.cources = builder.getCources();

        if (builder.getAge() < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        }
        this.age = builder.getAge();
        this.fee = builder.getFee();
    }

    // Static method to get a new builder instance
    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }
}
