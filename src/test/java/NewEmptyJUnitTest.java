/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.neomtech.javafxmettle.utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dell
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }
//     TODO: add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
     @Test
     public void hello() {
        System.out.println("Hellow World!");
         Utils.printImageName();
     }
}
