package unit6;

import javafx.application.*;
import javafx.event.EventType;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.*;

public class FxLoginDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label l1 = new Label("username");
        Label l2 = new Label("password");
        Label l3 = new Label("repassword");
        Label l4 = new Label("gender");
        Label l5 = new Label("course");
        Label l6 = new Label("faculty");
        TextField t1 = new TextField();
        PasswordField p1 = new PasswordField();
        PasswordField p2 = new PasswordField();
        RadioButton r1 = new RadioButton("male");
        RadioButton r2 = new RadioButton("female");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);// adding r1 to toggle group
        r2.setToggleGroup(tg);
        CheckBox c1 = new CheckBox("C");
        CheckBox c2 = new CheckBox("C++");
        CheckBox c3 = new CheckBox("Web");
        ChoiceBox cb = new ChoiceBox();// drop down menu
        cb.getItems().addAll("bca", "csit", "bim");
        Button b1 = new Button("submit");
        // adding component into grid pane
        GridPane gp = new GridPane();
        gp.add(l1, 0, 0);
        gp.add(t1, 1, 0);
        gp.add(l2, 0, 1);
        gp.add(p1, 1, 1);
        gp.add(l3, 0, 2);
        gp.add(p2, 1, 2);
        gp.add(l4, 0, 3);
        gp.add(r1, 1, 3);
        gp.add(r2, 2, 3);
        gp.add(l5, 0, 4);
        gp.add(c1, 1, 4);
        gp.add(c2, 2, 4);
        gp.add(c3, 3, 4);
        gp.add(l6, 0, 5);
        gp.add(cb, 1, 5);
        gp.add(b1, 0, 6);

        Scene sc = new Scene(gp, 400, 400);
        stage.setTitle("login");
        stage.setScene(sc);
        stage.show();
    }
}
