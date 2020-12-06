/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxmettle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
//        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
    }

    //Creating the mouse event handler 
    EventHandler<javafx.scene.input.MouseEvent> eventHandler
            = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            ImageView imageView = (ImageView) e.getSource();
            System.out.println("ImageView Clicked!");
            System.out.println("ImageView ID : " + imageView.getId());
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initGridPaneWithImage();
    }

    private void initGridPaneWithImage() {
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 4; row++) {
                ImageView imageView = new ImageView();
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                imageView.setId(Integer.toString(row) + Integer.toString(col));
                Image image = new Image("images/" + "block.png");
                imageView.setImage(image);
                imageView.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
                gridPane.add(imageView, col, row);
            }
        }
    }

}
