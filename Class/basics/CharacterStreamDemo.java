
package Unit1;
import java.io.*;
import java.util.*;
public class CharacterStreamDemo {
    public static void main(String[] args) {
        try{
     File f1 = new File("csit2.txt");
     f1.createNewFile();
     //writing through chracter stream
     FileWriter fw = new FileWriter(f1);
     Scanner sc = new Scanner(System.in);
     System.out.println("enter line of text");
     String data = sc.next();
     fw.write(data); 
     fw.close();
     //reading from file
     FileReader fr = new FileReader(f1);
     //reading through scanner object 
     Scanner sc1 = new Scanner(fr);
     if(sc1.hasNextLine()){
            System.out.println(sc1.nextLine());
        }
        fr.close();
        }catch(IOException i){
            System.out.println(i);
        }
     
    }
   
}
