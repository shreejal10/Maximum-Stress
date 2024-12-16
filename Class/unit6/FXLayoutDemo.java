package unit6;

import javafx.application.*;
import javafx.stage.*;//main window
import javafx.scene.*;
import javafx.scene.control.*;//button, textfield
import javafx.scene.layout.*;//diff layout
import javafx.event.*;//event handling

public class FXLayoutDemo extends Application {
    public static void main(String[] args) {
        System.out.println("Name: Shreejal Dhungana \t Section: A");
        System.out.println("LAB 5 \t Question 3");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // in javafx, stage is a main window, scene is
        // a subwindow. controls are put in layout,
        // layout is added into scene and scene is finally
        // added into stage
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Label l1 = new Label("result");
        // FlowPane: added content from left to right aand
        // if there is no any space then places the content
        // into next line
        // FlowPane fp = new FlowPane();
        // fp.setHgap(10);//horizontal gap between comp
        // fp.getChildren().add(b1);
        // fp.getChildren().add(b2);
        // fp.getChildren().add(b3);
        // fp.getChildren().add(l1);

        // GridPane:add comp in term of row and col
        // GridPane gp = new GridPane();
        // gp.add(b1, 0, 0);//adding in 0,0
        // gp.add(b2,1,0);//1,0 coordinate
        // gp.add(b3,2,0);//2,0 coordinate
        // gp.add(l1, 0, 1);//0,1 coordinate

        // BorderPane: add comp in form of direction
        // BorderPane bp = new BorderPane();
        // bp.setCenter(l1);
        // bp.setLeft(b1);
        // bp.setRight(b2);
        // bp.setTop(b3);
        // bp.setBottom(b4);

        // HBox: set all the component horizontally
        // HBox hb = new HBox();
        // hb.getChildren().addAll(b1,b2,b3,b4,l1);

        // VBox: set all the component vertically
        VBox vb = new VBox();
        vb.getChildren().addAll(b1, b2, b3, b4, l1);
        // handling action event
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                l1.setText("button1 is clicked");
            }

        });
        // add layout into scene
        Scene sc = new Scene(vb, 300, 300);
        // add scene to stage
        stage.setTitle("Layout Demo");
        stage.setScene(sc);
        stage.show();

    }

}
