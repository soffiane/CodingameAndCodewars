package hackerrank;

/**
 * Day 4 : Class vs Instance
 * <p>
 * Task
 * Write a Person class with an instance variable age,and a constructor that takes an integer,initialAge, as a parameter.
 * The constructor must assign initialAge to age after confirming the argument passed as initialAge is not negative;
 * if a negative argument is passed as initialAge, the constructor should set age to 0 and print Age is not valid, setting age to 0..
 * In addition, you must write the following instance methods:
 * <p>
 * yearPasses() should increase the  instance variable by .
 * amIOld() should perform the following conditional actions:
 * If , print You are young..
 * If  and , print You are a teenager..
 * Otherwise, print You are old..
 */
public class Person {

    private int age;

    public Person(int initialAge) {
        if (initialAge > 0) {
            this.age = initialAge;
        } else {
            this.age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if (this.age < 13) {
            System.out.println("You are young.");
        } else if (this.age < 18) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are old.");
        }

    }

    public void yearPasses() {
        this.age++;
    }

    public static void main(String[] args) {
        int[] tab = {4, -1, 10, 16, 18};
        for (int age : tab) {
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
    }
}
