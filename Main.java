import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
       launch(args); 
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = FXMLLoader.load(getClass().getResource("View.fxml"));
        stage.setScene(scene);
        stage.setTitle("Booking Hotel Room");
        stage.show();
    
}
}
