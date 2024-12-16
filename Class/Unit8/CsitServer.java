
package Unit8;

/**
 *
 * @author ShreejalDhungana
 * RMI stands for Remote Method Invocation in which one object can invoke method of another object running in separate JVM.
 * It consists three parameters
 *  remote object from which services are provided
 *  server which uses service provider to provide services to client
 *  client uses request services from server
 * 
 * For server rmi registry should be created and for client registry should be invoked.
 * client send needed parameter to server known as marshalling and it invoke required parameter from server known as unmarshalling
 * 
 * STEPS to create RMI
 * 1. Create remote object (interface)
 * 2. Create server (SKELETON) by registering rmi registry
 * 3. Create client (STUB) by invoking rmi registry
 */
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
public class CsitServer extends UnicastRemoteObject  implements ServiceProvider{
    public CsitServer ()throws Exception  {}
    
    //implements method defined by service provider interface
    @Override
    public int findSum(int x, int y){
        return x+y;
    }
    
    @Override
    public String findReverse(String data){
        String temp = "";
        char ch;
        for (int i=data.length(); i>=0; i++){
            ch = data.charAt(i);
            temp = ch+temp;
        }
        String result = "Original string is " + data +". The reverse is "+ temp;
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        //register server
        try{
        Registry reg = LocateRegistry.createRegistry(7777);
        reg.rebind("csitserver", new CsitServer());
            System.out.println("Server Ready to Serve");
        }catch(RemoteException r){
            System.out.println("Error: "+r);
        }
        
    }
}
