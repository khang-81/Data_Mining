// =================== SINGLETON ===================
class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() {}
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public void connect() {
        System.out.println("Connected to Database!");
    }
}

// =================== FACTORY ===================
interface Product {
    void info();
}

class Laptop implements Product {
    public void info() {
        System.out.println("Laptop created");
    }
}

class Phone implements Product {
    public void info() {
        System.out.println("Phone created");
    }
}

class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equalsIgnoreCase("laptop")) return new Laptop();
        if (type.equalsIgnoreCase("phone")) return new Phone();
        return null;
    }
}

// =================== CHAIN OF RESPONSIBILITY ===================
abstract class Approver {
    protected Approver next;
    public void setNext(Approver next) {
        this.next = next;
    }
    public abstract void approve(int amount);
}

class Employee extends Approver {
    public void approve(int amount) {
        if (amount < 1000) {
            System.out.println("Employee approved order: $" + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

class Manager extends Approver {
    public void approve(int amount) {
        if (amount < 10000) {
            System.out.println("Manager approved order: $" + amount);
        } else if (next != null) {
            next.approve(amount);
        }
    }
}

class Director extends Approver {
    public void approve(int amount) {
        System.out.println("Director approved order: $" + amount);
    }
}

// =================== ADAPTER ===================
interface NewPaymentGateway {
    void pay(int amount);
}

class OldPaymentSystem {
    public void makePayment(int amount) {
        System.out.println("Paid $" + amount + " using OLD Payment System");
    }
}

class PaymentAdapter implements NewPaymentGateway {
    private OldPaymentSystem oldSystem;
    public PaymentAdapter(OldPaymentSystem oldSystem) {
        this.oldSystem = oldSystem;
    }
    public void pay(int amount) {
        System.out.println("Adapter converting request...");
        oldSystem.makePayment(amount);
    }
}

// =================== MAIN DEMO ===================
public class Main {
    public static void main(String[] args) {
        // --- Singleton ---
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect();

        // --- Factory ---
        Product p1 = ProductFactory.createProduct("laptop");
        p1.info();
        Product p2 = ProductFactory.createProduct("phone");
        p2.info();

        // --- Chain of Responsibility ---
        Approver emp = new Employee();
        Approver mgr = new Manager();
        Approver dir = new Director();
        emp.setNext(mgr);
        mgr.setNext(dir);
        emp.approve(500);
        emp.approve(5000);
        emp.approve(20000);

        // --- Adapter ---
        OldPaymentSystem oldPay = new OldPaymentSystem();
        NewPaymentGateway gateway = new PaymentAdapter(oldPay);
        gateway.pay(1500);
    }
}
