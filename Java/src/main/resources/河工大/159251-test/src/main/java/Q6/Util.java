package Q6;


import org.junit.platform.commons.util.Preconditions;

/**
 * Q6
 * @author add name here
 * @id add ID here
 */

public class Util {

    // tests are in the tests directory of the project
    public static int divide(int n, int d) {
        if (d == 0)
            throw new IllegalArgumentException();
        return n / d;
    }

    public static String getGreeting(Person name) {
        Preconditions.notNull(name, "name cannot be null");
        return getTitle(name) + " " + name.getName();
    }

    private static String getTitle(Person name) {
        Preconditions.notNull(name, "name cannot be null");
        switch (name.getGender()) {
            case "F": return "Ms.";
            case "M": return "Mr.";
            default:
                return "M.";
        }
    }

}
