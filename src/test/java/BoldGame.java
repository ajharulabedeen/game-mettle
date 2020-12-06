
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BoldGame extends Application {

    @Override
    public void start(Stage stage) {

//Creating a Grid Pane
        GridPane gridPane = new GridPane();

//Setting size for the pane
        gridPane.setMinSize(400, 200);

//Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

//Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

//Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

//Arranging all the nodes in the grid
        gridPane.add(new Text("Card 1"), 0, 0);
        gridPane.add(new Text("Card 2"), 1, 0);
        gridPane.add(new Text("Card 3"), 0, 1);
        gridPane.add(new Text("Card 4"), 1, 1);

//Creating a scene object
        Scene scene = new Scene(gridPane);

//Setting title to the Stage
        stage.setTitle("Grid Pane Example");

//Adding scene to the stage
        stage.setScene(scene);

//Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
