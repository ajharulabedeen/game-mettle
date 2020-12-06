/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxmettle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import xyz.neomtech.javafxmettle.utils.Pattern;
import xyz.neomtech.javafxmettle.utils.Shape;
import xyz.neomtech.javafxmettle.utils.Size;
import xyz.neomtech.javafxmettle.utils.Utils;

import static xyz.neomtech.javafxmettle.utils.Shape.circle;

/**
 * @author Dell
 */
public class GridPaneController implements Initializable {

    @FXML
    private GridPane gridPane;

    @FXML
    private CheckBox p1;
    @FXML
    private CheckBox p2;
    @FXML
    private CheckBox p3;
    @FXML
    private CheckBox p4;
    @FXML
    private Label currentPlayerLabel;

    List<ImageView> imageViewList = new ArrayList<>();

    List<Cards> cardsList = new ArrayList<>();
    //    List<Cards> currentCards = new ArrayList<>();//20 cards
    Cards[][] currentCards = new Cards[4][5];
    List<Cards> usedCards = new ArrayList<>();
    List<Cards> selectedCards = new ArrayList<>();

    Players playersCurrent = new Players();
    Players player1 = new Players("P1");
    Players player2 = new Players("P2");
    Players player3 = new Players("P3");
    Players player4 = new Players("P4");

    @FXML
    private void checkBoxGrouping(MouseEvent mouseEvent) {
        CheckBox checkBox = (CheckBox) mouseEvent.getSource();
        String id = checkBox.getId();
        if (id.equals("p1")) {
            p2.setSelected(false);
            p3.setSelected(false);
            p4.setSelected(false);
            playersCurrent = player1;
        } else if (id.equals("p2")) {
            p1.setSelected(false);
            p3.setSelected(false);
            p4.setSelected(false);
            playersCurrent = player2;
        } else if (id.equals("p3")) {
            p1.setSelected(false);
            p2.setSelected(false);
            p4.setSelected(false);
            playersCurrent = player3;
        } else if (id.equals("p4")) {
            p1.setSelected(false);
            p2.setSelected(false);
            p3.setSelected(false);
            playersCurrent = player4;
        }
//        currentPlayerLabel.setText("Current Player : \n" + checkBox.getId());
    }

    //Creating the mouse event handler
    EventHandler<javafx.scene.input.MouseEvent> eventHandler
            = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            ImageView imageView = (ImageView) e.getSource();
            int row = Integer.parseInt(imageView.getId().split("")[0]);
            int col = Integer.parseInt(imageView.getId().split("")[1]);
            Cards cards = currentCards[row][col];
            if (!cards.turnedOver) {
                String imageName = cards.getImageName();
//                Image image =
            }
            System.out.println("ImageView Clicked!");
            System.out.println("ImageView ID : " + imageView.getId());
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initGridPaneWithImage();
        makingCards();
        initCurrentCardList();
    }

    Random random = new Random();

    public void initCurrentCardList() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int randomNumber = random.nextInt((cardsList.size() - 1));
                currentCards[row][col] = cardsList.get(randomNumber);
                cardsList.remove(randomNumber);
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.println(currentCards[row][col]);
            }
        }
        System.out.println(cardsList.size());
//        for (int x = 0; x < 20; x++) {
//            int randomNumber = random.nextInt(cardsList.size() - 1);
//            currentCards.add(cardsList.get(randomNumber));
//            usedCards.add(cardsList.get(randomNumber));
//            cardsList.remove(randomNumber);
//            System.out.println("remaining cards : " + cardsList.size());
//        }
//        currentCards.forEach(s -> System.out.println(s));
//        System.out.println(currentCards.size());for
    }

    private void initGridPaneWithImage() {
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 4; row++) {
                ImageView imageView = new ImageView();
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                imageView.setId(Integer.toString(row) + Integer.toString(col));
                imageView.setImage(getImage("block"));
                imageView.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
                gridPane.add(imageView, col, row);
            }
        }
    }

    private Image getImage(String name) {
        return new Image("images/" + name + ".png");
    }

    public void makingCards() {
        Utils.imageName.forEach(iName -> {
//            circle_L_blue_angle.png //ref values.
            String[] s = iName.split("_");
            Cards card = new Cards();
            card.setShape(setShape(s[0]));
            card.setSize(setSize(s[1]));
            card.setColor(setColor(s[2]));
            card.setPattern(setPattern(s[3]));
            card.setImageName(iName);
            cardsList.add(card);
        });
        cardsList.forEach(s -> System.out.println(s.toString()));
    }

    private Enum setPattern(String newString) {
        String s = newString.replace(".png", "");
        Enum pattern = null;
        if (s.equals(Pattern.angle.toString())) {
            pattern = Pattern.angle;
        } else if (s.equals(Pattern.hori.toString())) {
            pattern = Pattern.hori;
        } else if (s.equals(Pattern.star.toString())) {
            pattern = Pattern.star;
        }
        return pattern;
    }

    private Enum setColor(String s) {
        Enum color = null;
        if (s.equals(xyz.neomtech.javafxmettle.utils.Color.blue.toString())) {
            color = xyz.neomtech.javafxmettle.utils.Color.blue;
        } else if (s.equals(xyz.neomtech.javafxmettle.utils.Color.red.toString())) {
            color = xyz.neomtech.javafxmettle.utils.Color.red;
        } else if (s.equals(xyz.neomtech.javafxmettle.utils.Color.green.toString())) {
            color = xyz.neomtech.javafxmettle.utils.Color.green;
        }
        return color;
    }

    private Enum setSize(String s) {
        Enum size = null;
        if (s.equals("L")) {
            size = Size.L;
        } else if (s.equals("m")) {
            size = Size.m;
        } else if (s.equals("s")) {
            size = Size.s;
        }
        return size;
    }

    private Enum setShape(String s) {
        Enum shape = null;
        if (s.equals("circle")) {
            shape = Shape.circle;
        } else if (s.equals("heart")) {
            shape = Shape.heart;
        } else if (s.equals("star")) {
            shape = Shape.star;
        }
        return shape;
    }

}
