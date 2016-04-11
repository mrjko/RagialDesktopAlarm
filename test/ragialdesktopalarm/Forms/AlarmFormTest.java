/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ragialdesktopalarm.Forms;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jko
 */
public class AlarmFormTest {
    
    public AlarmFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        JFrame AlarmForm = new AlarmForm();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCharName method, of class AlarmForm.
     */
    @Test
    public void testGetCharName() {
        System.out.println("getCharName");
        AlarmForm.searchField.setText("Random");
        String expResult = "Random";
        String result = AlarmForm.getCharName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServerName method, of class AlarmForm.
     */
    @Test
    public void testGetServerName() {
        System.out.println("getServerName");
        String expResult = "s=6";
        String result = AlarmForm.getServerName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getDatabaseURL method, of class AlarmForm.
     */
    @Test
    public void testGetDatabaseURL() {
        AlarmForm.searchField.setText("Random");        
        System.out.println("getDatabaseURL Test:");
        String expResult = "http://ropd.info/?name=Random&s=6";
        String result = AlarmForm.getDatabaseURL();
        assertEquals(expResult, result);
    }


    /**
     * Test of alertUser method, of class AlarmForm.
     */
    @Test
    public void testAlertUser() {
        System.out.println("alertUser");
        String s = "";
        AlarmForm instance = new AlarmForm();
        instance.alertUser(s);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
