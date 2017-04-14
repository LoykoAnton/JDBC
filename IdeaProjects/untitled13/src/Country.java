import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import javafx.beans.property.*;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Country {
    private MyConnection connection;
    private StringProperty code;
    private StringProperty name;
    private StringProperty continent;
    private StringProperty region;
    private IntegerProperty surfaceArea;
    private IntegerProperty indepYear;
    private IntegerProperty population;
    private IntegerProperty gnp;
    private StringProperty localName;
    private IntegerProperty capital;

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getContinent() {
        return continent.get();
    }

    public StringProperty continentProperty() {
        return continent;
    }

    public Integer getPopulation() {
        return population.get();
    }

    public IntegerProperty populationProperty() {
        return population;
    }

    public Integer getSurfaceArea() {return surfaceArea.get();}

    public IntegerProperty surfaceAreaProperty() {
        return surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear.get();
    }

    public IntegerProperty indepYearProperty() {
        return indepYear;
    }

    public Integer getGnp() {
        return gnp.get();
    }

    public IntegerProperty gnpProperty() {
        return gnp;
    }

    public String getLocalName() { return localName.get();}

    public StringProperty localNameProperty() {
        return localName;
    }

    public Integer getCapital() { return capital.get();}

    public IntegerProperty capitalProperty() {
        return capital;
    }

    public MyConnection getConnection() {
        return connection;
    }

    public String getRegion() { return region.get();}

    public StringProperty regionProperty() {return region;}

    Country(MyConnection connection, String code, String name, String continent, String region, int population, int surfaceArea, int indepYear, int gnp, String localName, int capital) {
        this.connection = connection;
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.continent = new SimpleStringProperty(continent);
        this.region = new SimpleStringProperty(region);
        this.surfaceArea = new SimpleIntegerProperty(surfaceArea);
        this.indepYear = new SimpleIntegerProperty(indepYear);
        this.gnp = new SimpleIntegerProperty(gnp);
        this.localName = new SimpleStringProperty(localName);
        this.capital = new SimpleIntegerProperty(capital);
        this.population =new SimpleIntegerProperty(population);
    }


}
