import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            RMIServer.RemoteService service = (RMIServer.RemoteService) Naming.lookup("rmi://localhost:1099/RemoteService");

            int result = service.factorial(5);
            String message = service.concat("Hello", "Java");

            System.out.println("Factorial of 5: " + result);
            System.out.println("Concatenated: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
