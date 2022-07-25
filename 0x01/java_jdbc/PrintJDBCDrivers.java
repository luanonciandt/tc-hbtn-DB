import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        System.out.println("Nome e verso do driver encontrados.");
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
            Driver driver = e.nextElement();
            print(driver);
        }
    }

    public static void print(Driver driver) {
        String name = driver.getClass().getName();
        int majorVersion = driver.getMajorVersion();
        int minorVersion = driver.getMinorVersion();
        System.out.println("Nome: " + name);
        System.out.println("Versao Major: " + majorVersion);
        System.out.println("Versao Minor: " + minorVersion);

    }
}
