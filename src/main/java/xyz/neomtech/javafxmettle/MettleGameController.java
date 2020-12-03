package xyz.neomtech.javafxmettle;

import java.io.FileInputStream;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import xyz.neomtech.javafxmettle.utils.Utils;

public class MettleGameController {

    Random rand = new Random();

    @FXML
    private ImageView image_1_1;

//    @FXML
//    private ImageView e2b_imageView_to_show_mneaing;
    @FXML
    private void submitButtonAction() {
        System.out.println("Button action working!");
        Utils.printImageName();
    }

    @FXML
    private void image_11ClickAction() throws Exception {
        System.out.println("CLikced on Image 11!" + image_1_1.toString());
        String imageName = Utils.imageName.get(rand.nextInt(Utils.imageName.size() - 1));
        try {
            Image image = new Image("images/" + imageName);
//            Image image = new Image("images/cicrle_1.8.png");
            ImageView imageView = new ImageView(image);
            image_1_1.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("imageNameError : " + imageName);
        }
    }

}
