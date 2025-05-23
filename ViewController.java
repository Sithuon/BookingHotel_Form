import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ViewController implements Initializable {

    @FXML
    private Button button_submit;

    @FXML
    private CheckBox checkbox_breakfast;

    @FXML
    private CheckBox checkbox_playground;

    @FXML
    private CheckBox checkbox_skybar;

    @FXML
    private CheckBox checkbox_swimmingpool;

    @FXML
    private ChoiceBox<String> choicebox_roomtype;

    @FXML
    private DatePicker datepicker_arrivaldate;

    @FXML
    private ToggleGroup freepickup;

    @FXML
    private Label label_status;

    @FXML
    private RadioButton radiobutton_no;

    @FXML
    private RadioButton radiobutton_yes;

    @FXML
    private TextField textfield_email;

    @FXML
    private TextField textfield_name;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Initialize the choice box with room types
        choicebox_roomtype.getItems().addAll("Single", "Double");
       
       
        
    }

    @FXML
    void button_submit_action(ActionEvent event) {

        String roomtype = choicebox_roomtype.getValue();

        if(!textfield_name.getText().isEmpty() && !textfield_email.getText().isEmpty() 
        &&
         !datepicker_arrivaldate.getEditor().getText().isEmpty() 
         &&
        ( !radiobutton_no .isSelected() || !radiobutton_yes.isSelected())
        &&
         (checkbox_breakfast.isSelected() || checkbox_playground.isSelected() || checkbox_breakfast.isSelected() 
        || 
        checkbox_skybar.isSelected() ||  checkbox_swimmingpool.isSelected())) 
 {
            String name = textfield_name.getText();
            String email = textfield_email.getText();
            String arrivalDate = datepicker_arrivaldate.getEditor().getText();

            roomtype = "Room Type:";
            if( choicebox_roomtype.getValue() == "Single") {
                roomtype = "Room Type: Single";
            }
            else if( choicebox_roomtype.getValue() == "Double") {
                roomtype = "Room Type: Double";
            }
            // Free Pickup
            String freePickup = "Free Pickup: ";

            if( radiobutton_yes.isSelected()) {
                freePickup = "Free Pickup: Yes! please pick me up";
            } else if (radiobutton_no.isSelected()) {
                freePickup = "Free Pickup: No thanks";
            }
            // Special Requests
            String requests = "Specail Requests: ";
            if(checkbox_breakfast.isSelected()) {
                requests = requests + "Breakfast ";
            }
            else if(checkbox_playground.isSelected()) {
                requests = requests + "Playground, ";
            }
            else if(checkbox_skybar.isSelected()) {
                requests = requests + "Skybar ";
            }
            else if(checkbox_swimmingpool.isSelected()) {
                requests = requests + "Swimming Pool";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_playground.isSelected()) {
                requests = requests + "Breakfast, Playground ";
            }
            else if (checkbox_playground.isSelected() && checkbox_skybar.isSelected()) {
                requests = requests + "Playground, Skybar ";
            }
            else if (checkbox_skybar.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Skybar, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_skybar.isSelected()) {
                requests = requests + "Breakfast, Skybar ";
            }
            else if (checkbox_playground.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Playground, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Breakfast, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_playground.isSelected() && checkbox_skybar.isSelected()) {
                requests = requests + "Breakfast, Playground, Skybar ";
            }
            else if (checkbox_playground.isSelected() && checkbox_skybar.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Playground, Skybar, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_skybar.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Breakfast, Skybar, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_playground.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Breakfast, Playground, Swimming Pool ";
            }
            else if (checkbox_breakfast.isSelected() && checkbox_playground.isSelected() && checkbox_skybar.isSelected() && checkbox_swimmingpool.isSelected()) {
                requests = requests + "Breakfast, Playground, Skybar, Swimming Pool ";
            }
            else {
                requests = requests + "No special requests";
            }
            // Display the status message
            String content = "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Arrival Date: " + arrivalDate + "\n" +
                    roomtype + "\n" +
                    freePickup + "\n" +
                    requests;
            String file_name = textfield_name.getText() + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")) + ".txt";
        
        try {
            FileWriter fileWriter = new FileWriter(file_name);
            fileWriter.write(content);
            fileWriter.close();
            label_status.setText("Booking confirmed! Details saved to " + file_name);
        } catch (IOException e) {
            label_status.setText("Error saving booking details.");

        }
        label_status.setText("Thank you");
        label_status.setStyle("-fx-text-fill: green;");

        } else {
            label_status.setText("Please fill in all fields and select at least one option.");
            label_status.setText("Please fill the blanks. 🚫");
            label_status.setStyle("-fx-text-fill: red;");

        }

        }
    
    


}

    // Removed duplicate initialize method


// @Override
// public void initialize(URL location, ResourceBundle resources) {
//     // Populate choice_box_1 with animal options
//     choice_box_1.getItems().addAll("HelloWorld", "Helloworld", "HeloWorld");

//     // Populate choice_box_2 with action options
//     choice_box_2.getItems().addAll("arg", "args", "args[]");

//     // Populate choice_box_3 with additional options (example)
//     choice_box_3.getItems().addAll("println", "Println", "print1n");

//     // Set default values
//     choice_box_1.setValue(null);
//     choice_box_2.setValue(null);
//     choice_box_3.setValue(null);
// }

// @FXML
// void button_submit_action(ActionEvent event) {
//     String selectedAnimal = choice_box_1.getValue();
//     String selectedAction = choice_box_2.getValue();
//     String selectedEmotion = choice_box_3.getValue();

//     // Display the selected values in label_test_1
//     label_test_1
//             .setText("Animal: " + selectedAnimal + ", Action: " + selectedAction + ", Emotion: " + selectedEmotion);