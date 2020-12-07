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
import xyz.neomtech.javafxmettle.Cards;
import xyz.neomtech.javafxmettle.utils.*;

import javax.xml.transform.sax.SAXSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dell
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }
//     TODO: add test methods here.
//     The methods must be annotated with annotation @Test. For example:

//        @Test
    public void hello() {
        System.out.println("Hellow World!");
        Utils.printImageName();
    }

    //    @Test
    public void printAllNames() {
//        Utils.printImageName();
        Utils.imageName.forEach(iName -> {
            String[] s = iName.split("_");
            System.out.println(s.length);
            System.out.println(s[0]);
            System.out.println(s[1]);
        });
    }

    @Test
    public void testObjectEquals() {

        Cards card1 = new Cards();
        card1.setColor(Color.red);
        card1.setSize(Size.L);
        card1.setPattern(Pattern.hori);

        Cards card2 = new Cards();
        card2.setColor(Color.green);
        card2.setSize(Size.L);
        card2.setPattern(Pattern.hori);

        Cards card3 = new Cards();
        card3.setColor(Color.green);
        card3.setSize(Size.m);
        card3.setPattern(Pattern.angle);

//        c1 = red-L-hori
//        c2 = green-L-hori
//        c3 = green-m-angle
        
        System.out.println("C1:C2 = " + card1.equals(card2));
        System.out.println("C2:C3 = " + card2.equals(card3));
        System.out.println("C1:C3 = " + card1.equals(card3));
//        assertEquals(card1, card2);
//        assertEquals(card1, card3);

    }
}
