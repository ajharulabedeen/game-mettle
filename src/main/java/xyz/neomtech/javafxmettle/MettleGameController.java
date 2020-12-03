package xyz.neomtech.javafxmettle;

import java.io.FileInputStream;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import xyz.neomtech.javafxmettle.utils.Utils;

public class MettleGameController {

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

}
