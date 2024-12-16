
package Unit8;

/**
 *
 * @author ShreejalDhungana
 * Request server for services. It is done by looking up server's port and bind to it
 */
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class CsitClient{
    public static void main(String[] args) throws Exception {
        try {
            //lookup for server
            Registry creg = LocateRegistry.getRegistry(7777);
            ServiceProvider sp = (ServiceProvider) creg.lookup("csitserver");
            
            System.out.println("--For First Service");
            
            Scanner sc = new Scanner (System.in);
            System.out.println("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.println("Enter second number: ");
            int num2 = sc.nextInt();
            
            int result = sp.findSum(num1, num2);
            
            System.out.println("Sum is"+ result);
            
            System.out.println("--For second service");
            System.out.println("Enter any string: ");
            String str = sc.next();
            String res = sp.findReverse(str);
            
            System.out.println(res); 
           
            
        } catch (RemoteException e) {
            System.out.println(e);
        } catch(NotBoundException c){
            System.out.println(c);
        }
    }
}
