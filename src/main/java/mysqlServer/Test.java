package mysqlServer;



public class Test {

    public static void main(String[] args) {
        User user = new User("user1", "0000");
        System.out.println(user.checkUser());
        user.register();

        System.out.println(user.getError());



    }
}
