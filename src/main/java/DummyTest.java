public class DummyTest {
    public static void main(String[] args) {
        methodOne();
    }
    public static void methodOne(){
       methodTwo();
    }
    public static void methodTwo(){
        try {
            System.out.println(1/0);
        } catch(ArithmeticException e){
            e.printStackTrace();
            e.getMessage();
        }
    }
}
