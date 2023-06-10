package joshuaburt_sec005_ex04;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ex04.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500); //Set application viewport size
        stage.setTitle("Student Information System"); //This is the task bar title
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}