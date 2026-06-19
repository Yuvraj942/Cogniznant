public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("Starting application...");

        
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        
        System.out.println("\n--- Verification ---");
        System.out.println("logger1 hashcode: " + logger1.hashCode());
        System.out.println("logger2 hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Success: Both loggers are the exact same instance.");
        } else {
            System.out.println("Failure: Different instances were created.");
        }
    }
}