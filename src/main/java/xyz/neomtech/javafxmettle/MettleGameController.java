package xyz.neomtech.javafxmettle;

import java.io.IOException;
import javafx.fxml.FXML;
import xyz.neomtech.javafxmettle.utils.Utils;

public class MettleGameController {

    
    
    @FXML
    private void submitButtonAction() {
        System.out.println("Button action working!");
        Utils.printImageName();
    }

}
