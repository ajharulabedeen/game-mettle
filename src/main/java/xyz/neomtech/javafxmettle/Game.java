package xyz.neomtech.javafxmettle;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import xyz.neomtech.javafxmettle.utils.*;
import javafx.fxml.Initializable;

import javax.rmi.CORBA.Util;

public class Game implements Initializable {

    Random rand = new Random();

    //    row one.

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

    @FXML
    private ImageView image_1_1;
    @FXML
    private ImageView image_1_2;
    @FXML
    private ImageView image_1_3;
    @FXML
    private ImageView image_1_4;
    @FXML
    private ImageView image_1_5;

    @FXML
    private ImageView image_2_1;
    @FXML
    private ImageView image_2_2;
    @FXML
    private ImageView image_2_3;
    @FXML
    private ImageView image_2_4;
    @FXML
    private ImageView image_2_5;

    @FXML
    private ImageView image_3_1;
    @FXML
    private ImageView image_3_2;
    @FXML
    private ImageView image_3_3;
    @FXML
    private ImageView image_3_4;
    @FXML
    private ImageView image_3_5;

    @FXML
    private ImageView image_4_1;
    @FXML
    private ImageView image_4_2;
    @FXML
    private ImageView image_4_3;
    @FXML
    private ImageView image_4_4;
    @FXML
    private ImageView image_4_5;

    List<ImageView> imageViewList = new ArrayList<>();

    List<Cards> cardsList = new ArrayList<>();
    List<Cards> currentCards = new ArrayList<>();//25 cards
    List<Cards> usedCards = new ArrayList<>();
    List<Cards> selectedCards = new ArrayList<>();

    Players playersCurrent = new Players();
    Players player1 = new Players("P1");
    Players player2 = new Players("P2");
    Players player3 = new Players("P3");
    Players player4 = new Players("P4");

    @FXML
    private void submitButtonAction() {
        System.out.println("Button action working!");
        Utils.printImageName();
    }

    @FXML
    private void image_11ClickAction(MouseEvent me) throws Exception {
//        System.out.println("CLikced on Image 11!" + image_1_1.toString());
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());

        String imageName = Utils.imageName.get(rand.nextInt(Utils.imageName.size() - 1));

        try {
            Image image = new Image("images/" + imageName);
//            image_1_1.setImage(image);
            iv.setImage(image);
            System.out.println(iv.getImage());
            System.out.println(iv.getId());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("imageNameError : " + imageName);
        }
    }

    @FXML
    private void checkBoxP1Event() {
        if (p1.isSelected()) {
            p2.setSelected(false);
            p3.setSelected(false);
            p4.setSelected(false);
        }
        playersCurrent = player1;
        currentPlayerLabel.setText("Current Player : \n" + player1.getName());
    }

    @FXML
    private void checkBoxP2Event() {
        if (p2.isSelected()) {
            p1.setSelected(false);
            p3.setSelected(false);
            p4.setSelected(false);
        }
        playersCurrent = player2;
        currentPlayerLabel.setText("Current Player : \n" + player2.getName());
    }

    @FXML
    private void checkBoxP3Event() {
        if (p3.isSelected()) {
            p1.setSelected(false);
            p2.setSelected(false);
            p4.setSelected(false);
        }
        playersCurrent = player3;
        currentPlayerLabel.setText("Current Player : \n" + player3.getName());
    }

    @FXML
    private void checkBoxP4Event() {
        if (p4.isSelected()) {
            p1.setSelected(false);
            p2.setSelected(false);
            p3.setSelected(false);
        }
        playersCurrent = player4;
        currentPlayerLabel.setText("Current Player : \n" + player4.getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Utils.printImageName();
        makingCards();
        initCurrentCardList();
    }

    public void initCurrentCardList() {
        for (int x = 0; x < 25; x++) {
            int y = rand.nextInt(cardsList.size() - 1);
            currentCards.add(cardsList.get(y));
        }
        currentCards.forEach(s -> System.out.println(s));
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
        if (s.equals(Pattern.angle.toString())) pattern = Pattern.angle;
        else if (s.equals(Pattern.hori.toString())) pattern = Pattern.hori;
        else if (s.equals(Pattern.star.toString())) pattern = Pattern.star;
        return pattern;
    }

    private Enum setColor(String s) {
        Enum color = null;
        if (s.equals(Color.blue.toString())) color = Color.blue;
        else if (s.equals(Color.red.toString())) color = Color.red;
        else if (s.equals(Color.green.toString())) color = Color.green;
        return color;
    }

    private Enum setSize(String s) {
        Enum size = null;
        if (s.equals("L")) size = Size.L;
        else if (s.equals("m")) size = Size.m;
        else if (s.equals("s")) size = Size.s;
        return size;
    }

    private Enum setShape(String s) {
        Enum shape = null;
        if (s.equals("circle")) shape = Shape.circle;
        else if (s.equals("heart")) shape = Shape.heart;
        else if (s.equals("star")) shape = Shape.star;
        return shape;
    }

    @FXML
    private void image_1_1Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
        Cards cards = currentCards.get(0);
        if (!cards.turnedOver) {
            Image image = new Image("images/" + currentCards.get(0).getImageName());
            iv.setImage(image);
            currentCards.get(0).setTurnedOver(true);
        }
    }

    @FXML
    private void image_1_2Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_1_3Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_1_4Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_1_5Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_2_1Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_2_2Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_2_3Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_2_4Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_2_5Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_3_1Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_3_2Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_3_3Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_3_4Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_3_5Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_4_1Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_4_2Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_4_3Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_4_4Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }

    @FXML
    private void image_4_5Action(MouseEvent me) throws Exception {
        ImageView iv = (ImageView) me.getSource();
        System.out.println(iv.getId());
    }


}
