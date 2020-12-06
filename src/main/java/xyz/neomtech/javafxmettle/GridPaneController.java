/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxmettle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static xyz.neomtech.javafxmettle.utils.Shape.circle;

/**
 * @author Dell
 */
public class GridPaneController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private GridPane gridPane;

    @FXML
    private void mouseEntered(MouseEvent e) {
        Node source = (Node) e.getSource();
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
    }

    //Creating the mouse event handler 
    EventHandler<javafx.scene.input.MouseEvent> eventHandler
            = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            Button b = (Button) e.getSource();
            System.out.println("Button Clicked!");
            System.out.println("Button ID : " + b.getId());
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setId("TT");
        Button b = new Button("My Button");
        b.setId("b1");
        gridPane.add(b, 0, 0);
        b.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
//        System.out.println(gridPane.);
    }

}
