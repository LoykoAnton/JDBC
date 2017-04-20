import com.mysql.fabric.jdbc.FabricMySQLDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyConnection {

    private final static String URL = "jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false";
    private static String USER = "root";
    private static String PASS = "root";
    private Connection connection;
    private Driver driver;
    private Statement statement;
    private Set<City> city = new HashSet<>();
    private Set<Country> country = new HashSet<>();
    private Set<Language> language = new HashSet<>();
    private Main app;

    public MyConnection() {
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setApp(Main app) {
        this.app = app;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() throws SQLException {
        statement.close();
        connection.close();
        //user = null;
    }

    ObservableList<City> getCity()  {
        ObservableList<City> list = FXCollections.observableArrayList();
        ResultSet citySet = getResultSet("select * from city");
        Set<City> set = new LinkedHashSet<>();
        try {
            while (citySet.next()) {
                Integer id = citySet.getInt("ID");
                String name = citySet.getString("Name");
                String countryCode = citySet.getString("CountryCode");
                String district = citySet.getString("District");
                Integer population = citySet.getInt("Population");
                set.add(new City(this, id, name, countryCode, district, population));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        city = set;
        list.addAll(city);
        return list;
    }
    public void deleteCity(int id){
        String sql = "DELETE FROM `world`.`city` WHERE `id`= '"+id+"'";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Country> getAllCountry() {
        ObservableList<Country> list = FXCollections.observableArrayList();
        list.addAll(allCountry());
        return list;
    }

    private Set<Country> allCountry() {
        String sql = "select Code, Name, Continent, Region,  continent, region, surfaceArea, indepYear, population, gnp, localName, capital from country ";
        country = getSetCountry(getResultSet(sql));
        return country;
    }

    public ObservableList<Country> getAllSelectedCountry() {
        ObservableList<Country> list = FXCollections.observableArrayList();
        list.addAll(allCountry());
        return list;
    }

    private Set<Country> getSetCountry(ResultSet resultSet) {
        Set<Country> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                String code = resultSet.getString("Code");
                String name = resultSet.getString("Name");
                String continent = resultSet.getString("Continent");
                String region = resultSet.getString("Region");
                Integer surfaceArea = resultSet.getInt("SurfaceArea");
                Integer indepYear = resultSet.getInt("IndepYear");
                Integer population = resultSet.getInt("Population");
                Integer gnp = resultSet.getInt("GNP");
                String localName = resultSet.getString("LocalName");
                Integer capital = resultSet.getInt("Capital");
                set.add(new Country(this, code, name, continent, region, surfaceArea, indepYear, population, gnp, localName, capital));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
    public void deleteCountry(String code){
        String sql = "DELETE FROM `world`.`country` WHERE `Code`= '"+code+"'";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getResultSet(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Language> getAllLanguage() {
        ObservableList<Language> list = FXCollections.observableArrayList();
        list.addAll(allLanguage());
        return list;
    }

    private Set<Language> allLanguage() {
        String sql = "select * from countrylanguage ";
        language = getSetLanguage(getResultSet(sql));
        return language;
    }

    public ObservableList<Language> getAllSelectedLanguage() {
        ObservableList<Language> list = FXCollections.observableArrayList();
        list.addAll(allLanguage());
        return list;
    }

    private Set<Language> getSetLanguage(ResultSet resultSet) {
        Set<Language> set = new LinkedHashSet<>();
        try {
            while (resultSet.next()) {
                String countryCode = resultSet.getString("CountryCode");
                String language = resultSet.getString("Language");
                String isOfficial = resultSet.getString("IsOfficial");
                Double percentage = resultSet.getDouble("Percentage");
                set.add(new Language(this, countryCode, language, isOfficial,percentage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
    public void deleteLanguage(String countryCode,  String language){
        String sql = "DELETE FROM `world`.`countrylanguage` WHERE `CountryCode` = '" + countryCode + "' and `Language` = '" + language + "'";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean addLanguage(String countryCode, String language, String isOfficial, int percentage) {
        String sql = "insert into countrylanguage (CountryCode, Language, IsOfficial, Percentage) values ('" + countryCode + "', '" + language + "', '" + isOfficial + "', '" + percentage +"';";
        try {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

