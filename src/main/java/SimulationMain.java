import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        Properties database = new Properties();
        League league = new League("Dal-League");
        InputStream input = new FileInputStream("src\\database.properties");
        database.load(input);
        System.out.println(database.getProperty("dbuser"));
        System.out.println(database.getProperty("dbpass"));
        System.out.println(database.getProperty("dburl"));
    }
}
