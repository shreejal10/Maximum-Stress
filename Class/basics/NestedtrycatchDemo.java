//try catch inside another try catch block is nested
//try catch
//inner try catch will access outer catch if it
//cannot handle exception but reverse is not true
package Unit1;
import java.util.*;
public class NestedtrycatchDemo {
    public static void main(String[] args) {
        try{
            //inner try catch
            try{
    Scanner sc = new Scanner(System.in);
    System.out.println("enter any two number");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int div=num1/num2;
    System.out.println("div is "+div);
            }catch(ArrayIndexOutOfBoundsException ar){
                System.out.println(ar);
            }
        }catch(ArithmeticException a){
            System.out.println(a);
        }
    }
}
