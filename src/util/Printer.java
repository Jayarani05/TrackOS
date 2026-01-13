package util;

public class Printer {
    
    public static void header(String text) {
        System.out.println();
        System.out.println("=".repeat(40));
        System.out.println("  " + text);
        System.out.println("=".repeat(40));
    }
    
    public static void section(String text) {
        System.out.println();
        System.out.println("--- " + text + " ---");
    }
    
    public static void item(String text) {
        System.out.println("  * " + text);
    }
}
