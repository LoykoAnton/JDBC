import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CityController {

    private MyConnection connection;
    private ObservableList<City> list;
    private Main main;

    @FXML
    private TableView<City> table;
    @FXML
    private TableColumn<City, Integer> idColumn;
    @FXML
    private TableColumn<City, String> nameColumn;
    @FXML
    private TableColumn<City, String> countryCodeColumn;
    @FXML
    private TableColumn<City, String> districtColumn;
    @FXML
    private TableColumn<City, Integer> populationColumn;
    @FXML
    private TextField ID;
    @FXML
    private TextField idname;
    @FXML
    private TextField idCountryCode;
    @FXML
    private TextField idDistrict;
    @FXML
    private TextField idPopulation;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getCity();
        idColumn.setCellValueFactory(cellData -> cellData.getValue().IdProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        countryCodeColumn.setCellValueFactory(cellData -> cellData.getValue().countryCodeProperty());
        districtColumn.setCellValueFactory(cellData -> cellData.getValue().districtProperty());
        populationColumn.setCellValueFactory(cellData -> cellData.getValue().IdProperty().asObject());
        table.setItems(list);
    }
    @FXML
    private void onDelete () {
        connection.deleteCity(table.getSelectionModel().getSelectedItem().IdProperty().getValue());
        initialize();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}