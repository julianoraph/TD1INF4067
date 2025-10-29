interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

public class DIP_After {
    private Database database;

    public DIP_After(Database database) {
        this.database = database;
    }

    public void processOrder(String order) {
        database.save(order);
    }

    public static void main(String[] args) {
        Database db1 = new MySQLDatabase();
        DIP_After order1 = new DIP_After(db1);
        order1.processOrder("'Commande #1001'");

        Database db2 = new MongoDBDatabase();
        DIP_After order2 = new DIP_After(db2);
        order2.processOrder("'Commande #1002'");
    }
}
