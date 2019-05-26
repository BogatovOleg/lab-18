import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Random;

public class Main extends Application {

    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception{
        Random rand;
        myStage.setTitle("Demonstrate");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode,500,500);
        myStage.setScene(myScene);

        response = new Label("Push a btn");
        Button btnAlpha = new Button("Alpha");
        Button btnBeta = new Button("Beta");

        Alert alertAlpha = new Alert(Alert.AlertType.INFORMATION);
        Alert alertBeta = new Alert(Alert.AlertType.INFORMATION);
        alertAlpha.setHeaderText("Alpha was pressed");
        alertBeta.setHeaderText("Beta was pressed");

        btnAlpha.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                btnAlpha.setTranslateX(Math.random()*myScene.getWidth()-btnAlpha.getLayoutX()-btnAlpha.getWidth());
                btnAlpha.setTranslateY(Math.random()*myScene.getHeight()-btnAlpha.getLayoutY()-btnAlpha.getHeight());

            }
        });

        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Alpha was pressed");

                alertAlpha.showAndWait();
            }
        });

        btnBeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Beta was pressed");

                alertBeta.showAndWait();
            }
        });

        rootNode.getChildren().addAll(btnAlpha,btnBeta, response);
        myStage.show();
    }
}
