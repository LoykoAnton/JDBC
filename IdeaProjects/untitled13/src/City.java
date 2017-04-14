import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class City {
    private MyConnection connection;
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty countryCode;
    private StringProperty district;
    private StringProperty population;

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

    public String getPopulation() {
        return population.get();
    }

    public StringProperty populationProperty() {
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


    City(MyConnection connection, int id, String name, String countryCode, String district, String population ) {
        this.connection = connection;
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.countryCode = new SimpleStringProperty(countryCode);
        this.district = new SimpleStringProperty(district);
        this.population = new SimpleStringProperty(population);
    }


}
