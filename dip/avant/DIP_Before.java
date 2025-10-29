class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

public class DIP_Before {
    private MySQLDatabase database;

    public DIP_Before() {
        this.database = new MySQLDatabase();
    }

    public void processOrder(String order) {
        database.save(order);
    }

    public static void main(String[] args) {
        DIP_Before order = new DIP_Before();
        order.processOrder("'Commande client : #2025'");
    }
}
