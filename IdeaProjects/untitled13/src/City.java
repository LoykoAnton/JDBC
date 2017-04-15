import javafx.beans.property.*;

public class City {
    private MyConnection connection;
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty countryCode;
    private StringProperty district;
    private IntegerProperty population;

    public Integer getId() {
        return id.get();
    }

    public IntegerProperty IdProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCountryCode() {
        return countryCode.get();
    }

    public StringProperty countryCodeProperty() {
        return countryCode;
    }

    public int getPopulation() {
        return population.get();
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public String getDistrict() {
        return district.get();
    }

    public StringProperty districtProperty() {
        return district;
    }

    public MyConnection getConnection() {
        return connection;
    }


    City(MyConnection connection, int id, String name, String countryCode, String district, int population ) {
        this.connection = connection;
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.countryCode = new SimpleStringProperty(countryCode);
        this.district = new SimpleStringProperty(district);
        this.population = new SimpleIntegerProperty(population);
    }
}
