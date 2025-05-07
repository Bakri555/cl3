import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RMIServer {

    // Remote interface
    public interface RemoteService extends Remote {
        int factorial(int n) throws RemoteException;
        String concat(String s1, String s2) throws RemoteException;
    }

    // Implementation
    public static class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
        protected RemoteServiceImpl() throws RemoteException { super(); }

        public int factorial(int n) throws RemoteException {
            if (n == 0) return 1;
            return n * factorial(n - 1);
        }

        public String concat(String s1, String s2) throws RemoteException {
            return s1 + " " + s2;
        }
    }

    // Main method to run the server
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            RemoteServiceImpl service = new RemoteServiceImpl();
            Naming.rebind("RemoteService", service);
            System.out.println("RMI Server started on port 1099...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
