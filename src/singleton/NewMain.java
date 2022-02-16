
package singleton;


public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        System.out.println(a1);
        System.out.println(a2);
        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1);
        System.out.println(b2);
        
        a1.setX(4);
        a2.setX(6);
        System.out.println(a1.getX());
        System.out.println(a2.getX());
        
        b1.setX(3);
        System.out.println(b1.getX());
        b2.setX(8);
        System.out.println(b1.getX());
        

    }
    
}
