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
    private IntegerProperty percantage;

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

    public Integer getPercantage() {
        return percantage.get();
    }

    public IntegerProperty percantageProperty() {
        return percantage;
    }

    Language(MyConnection connection, String countryCode, String language, String isOfficial, int pepcantage) {
        this.connection = connection;
        this.countryCode = new SimpleStringProperty(countryCode);
        this.language = new SimpleStringProperty(language);
        this.isOfficial = new SimpleStringProperty(isOfficial);
        this.percantage = new SimpleIntegerProperty(pepcantage);
    }
}