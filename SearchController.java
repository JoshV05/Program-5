package mario.kart.program5;
// importing the necessary things
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;

public class SearchController {
    // connects the Labels, TextFields, and Buttons from Scene Builder to code,
    // so they can be changed or accessed
    @FXML
    private Label competitorInfo;

    @FXML
    private TextField enterID;

    @FXML
    private Button searchButton;

    // this method runs when the "Search" button is clicked
    // because of the On Mouse Clicked property in Scene Builder
    @FXML
    public void onMouseClick(MouseEvent mouseEvent) {
        // creates a new button object from the source of the mouse click
        Button button = (Button) mouseEvent.getSource();
        // temporary competitor object
        Competitor tempCompetitor;
        // I don't think this is really needed since there is only one button on this scene
        if (button.getText().equals("Search")) {
            // loops over the length of the competitor list - 100 by default... I think
            for (int i = 0; i < RegisterController.competitorsList.length; i++) {
                // checks to make sure the spot in the Array isn't empty
                // then checks if their ID equals the ID in the TextField
                if (RegisterController.competitorsList[i] != null && RegisterController.competitorsList[i].getID() == Integer.parseInt(enterID.getText())) {
                    // if those conditions are met, save the competitor into the temp competitor
                    tempCompetitor = RegisterController.competitorsList[i];
                    // sets the text for the label using the competitor toString method
                    competitorInfo.setText(tempCompetitor.toString());
                    break;
                }
                // changes label text to this if no matching ID was found
                competitorInfo.setText("Competitor Not Found");
            }

        }
    }
}



