package xyz.neomtech.javafxmettle;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import xyz.neomtech.javafxmettle.utils.Shape;
import xyz.neomtech.javafxmettle.utils.Size;
import xyz.neomtech.javafxmettle.utils.Utils;
import javafx.fxml.Initializable;

import javax.rmi.CORBA.Util;

public class Game implements Initializable {

    Random rand = new Random();

    //    row one.
//    @FXML
//    private ImageView image_1_1;
//    @FXML
//    private ImageView image_1_2;
//    @FXML
//    private ImageView image_1_3;
//    @FXML
//    private ImageView image_1_4;
//    @FXML
//    private ImageView image_1_5;
    //    @FXML
//    private ImageView e2b_imageView_to_show_mneaing;
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("imageNameError : " + imageName);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Utils.printImageName();
        makingCards();
    }

    List<Cards> cardsList = new ArrayList<>();

    public void makingCards() {
        Utils.imageName.forEach(iName -> {
            String[] s = iName.split("_");
            System.out.println(s.length);
//            System.out.println(s[0]);
//            System.out.println(s[1]);
            Cards card = new Cards();
            card.setShape(setShape(s[0]));
            card.setSize(setSize(s[1]));
            cardsList.add(card);
        });
        cardsList.forEach(s -> System.out.println(s.toString()));
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


}
