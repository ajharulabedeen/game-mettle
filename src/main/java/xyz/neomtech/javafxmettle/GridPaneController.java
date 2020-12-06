/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.javafxmettle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    Label cardRemains;

    @FXML
    Label p1Score;
    @FXML
    Label p1Term;
    @FXML
    Label p2Score;
    @FXML
    Label p2Term;
    @FXML
    Label p3Score;
    @FXML
    Label p3Term;
    @FXML
    Label p4Score;
    @FXML
    Label p4Term;

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

    int remainingCards = 81;

    List<ImageView> imageViewList = new ArrayList<>();

    List<Cards> cardsList = new ArrayList<>();
    //    List<Cards> currentCards = new ArrayList<>();//20 cards
    Cards[][] currentCards = new Cards[4][5];
    List<Cards> usedCards = new ArrayList<>();
    List<Cards> selectedCards = new ArrayList<>();

    Players playersCurrent = null;
    Players player1 = new Players("P1");
    Players player2 = new Players("P2");
    Players player3 = new Players("P3");
    Players player4 = new Players("P4");

    int matchCount = 0;

    @FXML
    private void submitButtonAction() {
        selectedCards.forEach(s -> System.out.println(s));
        matchCount = 0;
        selectedCards.forEach(c -> {
            cardsList.remove(c);
            currentCards[c.row][c.column] = getRandomCard();
            Parent parent = (Parent) gridPane.getParent();
            ImageView iv = (ImageView) parent.lookup("#" + c.selectedImageID);
            iv.setImage(getImage(Utils.blurImage));
            playersCurrent.setScore(playersCurrent.getScore() +1);
            matchCount++;
            if (matchCount > 2) {
                playersCurrent.setScore(playersCurrent.getScore() + 2);
            }
        });

        updateScore();
        updateTermPlayed();

        cardRemains.setText(Integer.toString(cardsList.size()));
        selectedCards.clear();
        playersCurrent = null;

    }

    private void updateScore() {
        if (playersCurrent.name.equals("P1")) {
            player1 = playersCurrent;
            p1Score.setText("Score : " + Integer.toString(player1.getScore()));
            p1.setSelected(false);
        } else if (playersCurrent.name.equals("P2")) {
            player2 = playersCurrent;
            p2Score.setText("Score : " + Integer.toString(player2.getScore()));
            p2.setSelected(false);
        } else if (playersCurrent.name.equals("P3")) {
            player3 = playersCurrent;
            p3Score.setText("Score : " + Integer.toString(player3.getScore()));
            p3.setSelected(false);
        } else if (playersCurrent.name.equals("P4")) {
            player4 = playersCurrent;
            p4Score.setText("Score : " + Integer.toString(player4.getScore()));
            p4.setSelected(false);
        }
    }

    public Cards getRandomCard() {
        int index = random.nextInt(cardsList.size());
        Cards c = cardsList.get(index);
        return c;
    }

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
        selectedCards.clear();
//        currentPlayerLabel.setText("Current Player : \n" + checkBox.getId());
    }

    //Creating the mouse event handler
    EventHandler<javafx.scene.input.MouseEvent> eventHandler
            = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            if (playersCurrent != null) {
//                playersCurrent.setTermPlayed(playersCurrent.getTermPlayed() + 1);
                ImageView imageView = (ImageView) e.getSource();
                int row = Integer.parseInt(imageView.getId().split("")[0]);
                int col = Integer.parseInt(imageView.getId().split("")[1]);
                Cards selectedCard = currentCards[row][col];
                if (!selectedCard.turnedOver) {
                    String imageName = selectedCard.getImageName();
                    imageView.setImage(getImage(imageName));
                    currentCards[row][col].setTurnedOver(true);
                    selectedCard.setSelectedImageID(imageView.getId());
                    selectedCards.add(selectedCard);
                    selectedCard.setRow(row);
                    selectedCard.setColumn(col);
                }
                if (selectedCards.size() > 1) {
                    for (int i = 0; i < selectedCards.size(); i++) {
                        if (selectedCards.get(i).equals(selectedCard)) {
                            System.out.println("MATCH-TRUE");
                            System.out.println("--" + selectedCard.toString());
                            System.out.println("==" + selectedCards.get(i).toString());
                        } else {
                            System.out.println("MATCH-FALSE");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                            }
                            //TODO: Rebulr Images.
                            for (int j = 0; j < selectedCards.size(); j++) {
                                Cards c = selectedCards.get(j);
                                Parent parent = gridPane.getParent(); // the Parent (or Scene) that contains the TextFields
                                ImageView iv = (ImageView) parent.lookup("#" + c.getSelectedImageID());
                                iv.setImage(getImage(Utils.blurImage));
                                currentCards[c.row][c.column].setTurnedOver(false);
                            }
                            //TODO:REMOVE
                            selectedCards.clear();
                            updateTermPlayed();
                            playersCurrent = null;
                        }
                    }
                }
                System.out.println("ImageView ID : " + imageView.getId());
            } else {
                System.out.println("Please Select A Player First!");
            }
        }
    };

    private void updateTermPlayed() {
        if (playersCurrent.name.equals("P1")) {
            player1 = playersCurrent;
            p1.setSelected(false);
            player1.setTermPlayed(player1.getTermPlayed() + 1);
            p1Term.setText("Term Played : " + Integer.toString(player1.getTermPlayed()));
        } else if (playersCurrent.name.equals("P2")) {
            player2 = playersCurrent;
            p2.setSelected(false);
            player2.setTermPlayed(player2.getTermPlayed() + 1);
            p2Term.setText("Term Played : " + Integer.toString(player2.getTermPlayed()));
        } else if (playersCurrent.name.equals("P3")) {
            player3 = playersCurrent;
            p3.setSelected(false);
            player3.setTermPlayed(player3.getTermPlayed() + 1);
            p3Term.setText("Term Played : " + Integer.toString(player3.getTermPlayed()));
        } else if (playersCurrent.name.equals("P4")) {
            player4 = playersCurrent;
            p4.setSelected(false);
            player4.setTermPlayed(player4.getTermPlayed() + 1);
            p4Term.setText("Term Played : " + Integer.toString(player4.getTermPlayed()));
        }
    }

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
                remainingCards--;
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.println(currentCards[row][col]);
            }
        }
        cardRemains.setText(Integer.toString(remainingCards));
        System.out.println(cardsList.size());
    }

    private void initGridPaneWithImage() {
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 4; row++) {
                ImageView imageView = new ImageView();
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                imageView.setId(Integer.toString(row) + Integer.toString(col));
//                imageView.setImage(getImage("block.png"));
                imageView.setImage(getImage("block.jpg"));
                imageView.setRotate(imageView.getRotate() + 90);
                imageView.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
                gridPane.add(imageView, col, row);
            }
        }
    }

    private Image getImage(String name) {
        return new Image("images/" + name);
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
