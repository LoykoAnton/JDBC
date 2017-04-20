import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import javafx.beans.property.*;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Language {
    private MyConnection connection;
    private StringProperty countryCode;
    private StringProperty language;
    private StringProperty isOfficial;
    private DoubleProperty percentage;

    public String getCountryCode() {
        return countryCode.get();
    }

    public StringProperty countryCodeProperty() {
        return countryCode;
    }

    public String getLanguage() {
        return language.get();
    }

    public StringProperty languageProperty() {
        return language;
    }

    public String getIsOfficial() {
        return isOfficial.get();
    }

    public StringProperty isOfficialProperty() {
        return isOfficial;
    }

    public Double getPercentage() {
        return percentage.get();
    }

    public DoubleProperty percentageProperty() {
        return percentage;
    }

    Language(MyConnection connection, String countryCode, String language, String isOfficial, Double pepcantage) {
        this.connection = connection;
        this.countryCode = new SimpleStringProperty(countryCode);
        this.language = new SimpleStringProperty(language);
        this.isOfficial = new SimpleStringProperty(isOfficial);
        this.percentage = new SimpleDoubleProperty(pepcantage);
    }
}
