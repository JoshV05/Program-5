package mario.kart.program5;
// importing the necessary things
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.collections.*;
import java.net.URL;
import java.util.ResourceBundle;

import static mario.kart.program5.Competitor.getNumCompetitors;
// implements Initializable because it is needed for the choiceBoxes
// I don't remember why it extends main to be honest
public class RegisterController extends Main implements Initializable {
    // connects the ChoiceBoxes, TextFields, and Buttons from Scene Builder to code,
    // so they can be changed or accessed
    @FXML
    private ChoiceBox<String> choiceBoxCharacters;
    @FXML
    private ChoiceBox<String> choiceBoxVehicleType;
    @FXML
    private ChoiceBox<String> choiceBoxVehicle;
    @FXML
    private Button registerButton;
    @FXML
    private TextField idText;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;

    // all the necessary arrays from program 3
    private String[] characters = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad",
            "Koopa Troopa", "Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach",
            "Baby Daisy"};
    private String[] vehicleTypes = {"Karts", "Bikes", "ATVs"};
    private String[] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser",
            "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker",
            "Sports Coupe", "Gold Standard"};
    private String[] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint",
            "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    private String[] ATVs = {"Standard ATV", "Wild Wiggler", "Teddy Buggy"};


    // this is the array where all the competitors are saved
    // ArrayLists were causing problems for some reason,
    // so now it's just an Array of size 100
    public static Competitor[] competitorsList = new Competitor[100];
    // gets a single competitor at the given index
    public static Competitor getCompetitor(int index) {
        return competitorsList[index];
    }
    // sets the competitor at a given index
    public void setCompetitor(int index, Competitor competitor) {
        competitorsList[index] = competitor;
    }


    // this method runs when the "Register" button is clicked
    // because of the On Mouse Clicked property in Scene Builder
    @FXML
    public void onMouseClick(MouseEvent mouseEvent) {
        // creates a new button object from the source of the mouse click
        Button button = (Button) mouseEvent.getSource();
        // I don't think this is really needed since there is only one button on this scene
        if (button.getText().equals("Register")) {
            // gets the information from all the text fields and choice boxes and sends them to the competitor constructor
            Competitor newCompetitor = new Competitor(Integer.parseInt(idText.getText()), firstNameText.getText(), lastNameText.getText(), choiceBoxCharacters.getValue(), choiceBoxVehicle.getValue());
            // takes that new competitor and saves it into the next slot in the competitor Array
            setCompetitor(getNumCompetitors() - 1, newCompetitor);
            System.out.println("New Competitor Added");
        }
    }

    // I don't entirely understand what this section does,
    // but it allows the choice boxes to update and send information
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // adds the characters array as items to the choice box
        // calls the getCharacter method when choice is changed
        choiceBoxCharacters.getItems().addAll(characters);
        choiceBoxCharacters.setOnAction(this::getCharacter);
        // adds the vehicle types array as items to the choice box
        // calls the getVehicleType method when choice is changed
        choiceBoxVehicleType.getItems().addAll(vehicleTypes);
        choiceBoxVehicleType.setOnAction(this::getVehicleType);
        // this choice box is set to an empty array by default
        // calls the getVehicle method when choice is changed
        ObservableList<String> empty = FXCollections.observableArrayList();
        choiceBoxVehicle.getItems().addAll(empty);
        choiceBoxVehicle.setOnAction(this::getVehicle);


    }

    public void getCharacter(ActionEvent event) {
        String myCharacter = choiceBoxCharacters.getValue();
        System.out.println(myCharacter);
    }

    public void getVehicleType(ActionEvent event) {
        // empty array
        ObservableList<String> empty = FXCollections.observableArrayList();
        // making a new string using the text from the vehicle type choice box
        String myVehicleType = choiceBoxVehicleType.getValue();

        // switch case depending on the text in vehicle type choice box
        // this is what changes the options in the vehicle choice box
        // when you change your choice in the vehicle type choice box
        switch (myVehicleType) {
            case "Karts": {
                // sets the items to an empty list
                // then adds the karts
                choiceBoxVehicle.setItems(empty);
                choiceBoxVehicle.getItems().addAll(karts);
                break;
            }
            case "Bikes": {
                // sets the items to an empty list
                // then adds the bikes
                choiceBoxVehicle.setItems(empty);
                choiceBoxVehicle.getItems().addAll(bikes);
                break;
            }
            case "ATVs": {
                // sets the items to an empty list
                // then adds the atvs
                choiceBoxVehicle.setItems(empty);
                choiceBoxVehicle.getItems().addAll(ATVs);
                break;
            }
        }
    }
    // gets the vehicle from the vehicle choice box
    public void getVehicle(ActionEvent event){
        String myVehicle = choiceBoxVehicle.getValue();
        System.out.println(myVehicle);
    }
}

