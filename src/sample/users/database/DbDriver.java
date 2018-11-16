package sample.users.database;

public class DbDriver {
    public static void main(String[] args) {

        DBConnect DD = new DBConnect();
        DD.createUserTable();
        DD.createEventTable();
        DD.printAllUser();
        DD.printAllEvent();
        DD.verifyExist("Arnold","11445");

    }
}
