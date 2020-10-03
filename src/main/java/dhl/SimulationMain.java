package dhl;

import dhl.LeagueModel.League;
import dhl.LeagueModel.Players;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SimulationMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        Properties database = new Properties();
//<<<<<<< HEAD:src/main/java/SimulationMain.java
        League league = new League("Dal-dhl.LeagueModel.League");
        Players player = new Players("Devam","Forward",true);
//        InputStream input = new FileInputStream("src\\database.properties");
//=======
        InputStream input = new FileInputStream("src/database.properties");
//>>>>>>> d15224683d83e284dd1846e06fde281487674257:src/main/java/dhl/SimulationMain.java
        database.load(input);
        System.out.println(database.getProperty("dbuser"));
        System.out.println(database.getProperty("dbpass"));
        System.out.println(database.getProperty("dburl"));
//        System.out.println();
    }
}
