import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
//        LegacyBillingSystem legacy = new LegacyBillingSystem();
//        IPaymentGateway gateway = new PaymentGatewayAdapter(legacy);
//
//        gateway.processPayment(101, new BigDecimal("10.50"));
//
//        try {
//            gateway.processPayment(102, null);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        try {
//            gateway.processPayment(103, new BigDecimal("-5.00"));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        try {
//            gateway.processPayment(104, new BigDecimal("10.999"));
//        } catch (ArithmeticException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }

        // ===== Task 2: Temperature Sensor Adapter =====
//        FahrenheitSensor fahrenheitSensor = new FahrenheitSensor();
//        ICelsiusSensor celsiusSensor = new TemperatureSensorAdapter(fahrenheitSensor);
//
//        double celsius = celsiusSensor.getTemperatureInCelsius();
//        System.out.println("Temperature in Celsius: " + celsius);

//        // ===== Task 3: Student Directory Adapter =====
//        LegacyStudentDirectory legacyDirectory = new LegacyStudentDirectory();
//        IModernDirectory modernDirectory = new StudentDirectoryAdapter(legacyDirectory);
//
//        System.out.println("Size: " + modernDirectory.size());
//        System.out.println("Index 0: " + modernDirectory.get(0)); // Alice
//        System.out.println("Index 3: " + modernDirectory.get(3)); // David
//
//        try {
//            modernDirectory.get(-1);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        try {
//            modernDirectory.get(4);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }

//        // ===== Task 4: Clock Adapter =====
//        LegacyClock legacyClock = new LegacyClock();
//        IModernCalendar calendar = new ClockAdapter(legacyClock);
//
//        LocalDate currentDate = calendar.getCurrentDate();
//        System.out.println("Current date (UTC): " + currentDate);

//        // ===== Task 5: CSV User Adapter =====
//        LegacyCsvUserStore legacyCsvUserStore = new LegacyCsvUserStore();
//        IUserSource userSource = new CsvUserAdapter(legacyCsvUserStore);
//
//        UserProfile user = userSource.getNextUser();
//        System.out.println("User: " + user);

//        // ===== Task 6: Database Adapter =====
//        LegacyDatabaseConnection legacyDatabaseConnection = new LegacyDatabaseConnection();
//        IRepository repository = new DatabaseAdapter(legacyDatabaseConnection);
//
//        try {
//            System.out.println("Record: " + repository.findById(1));
//        } catch (RecordNotFoundException | DatabaseLockedException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        try {
//            repository.findById(404);
//        } catch (RecordNotFoundException | DatabaseLockedException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }
//
//        try {
//            repository.findById(500);
//        } catch (RecordNotFoundException | DatabaseLockedException e) {
//            System.out.println("Caught: " + e.getMessage());
//        }

//        // ===== Task 7: Inventory Iterator Adapter =====
//        LegacyInventory legacyInventory = new LegacyInventory();
//        IInventoryIteratorProvider iteratorProvider = new InventoryIteratorAdapter(legacyInventory);
//
//        Iterator<String> inventoryIterator = iteratorProvider.getInventoryIterator();
//        while (inventoryIterator.hasNext()) {
//            System.out.println("Item: " + inventoryIterator.next());
//        }

        // ===== Task 8: Telemetry Logger Adapter =====
        EnterpriseTelemetryLogger enterpriseTelemetryLogger = new EnterpriseTelemetryLogger();
        ISimpleLogger logger = new TelemetryLoggerAdapter(enterpriseTelemetryLogger, "MyApp");

        logger.info("Application started");
        logger.warn("Low disk space");
        logger.error("Connection failed");






    }
}