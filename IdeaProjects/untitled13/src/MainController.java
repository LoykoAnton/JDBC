import javafx.fxml.FXML;

public class MainController {
    private Main main;

    @FXML
    public void OnLanguage() {
        main.setLanguage();
    }

    @FXML
    public void OnCity() {
        main.setCity();
    }

    @FXML
    public void OnCountry() {
        main.setCountry();
    }

    void setMain(Main main) {
        this.main = main;
    }
}