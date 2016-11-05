/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caspersfilmregister;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Casper
 */
public class FormIT {
    
    public FormIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createMovieForm method, of class Form.
     */
    @Test
    public void testCreateMovieForm() {
        System.out.println("createMovieForm");
        Form instance = new Form();
        instance.createMovieForm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGenreForm method, of class Form.
     */
    @Test
    public void testCreateGenreForm() {
        System.out.println("createGenreForm");
        Form instance = new Form();
        instance.createGenreForm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createRegissorForm method, of class Form.
     */
    @Test
    public void testCreateRegissorForm() {
        System.out.println("createRegissorForm");
        Form instance = new Form();
        instance.createRegissorForm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearGUI method, of class Form.
     */
    @Test
    public void testClearGUI() {
        System.out.println("clearGUI");
        Form instance = new Form();
        instance.clearGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
