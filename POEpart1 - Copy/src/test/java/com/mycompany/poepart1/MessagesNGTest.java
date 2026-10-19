/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.poepart1;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Student
 */
public class MessagesNGTest {
    
    public MessagesNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of sendingMessage method, of class Messages.
     */
    @Test
    public void testSendingMessage() {
        System.out.println("sendingMessage");
        Messages instance = new Messages();
        instance.sendingMessage();
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of returnTotalMessages method, of class Messages.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Messages instance = new Messages();
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of generateMessageID method, of class Messages.
     */
    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        Messages instance = new Messages();
        String expResult = "";
        String result = instance.generateMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of checkRecipientCell method, of class Messages.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cellphone = "";
        Messages instance = new Messages();
        String expResult = "";
        String result = instance.checkRecipientCell(cellphone);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createMessageHash method, of class Messages.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        int messageNumber = 0;
        String messageText = "";
        Messages instance = new Messages();
        String expResult = "";
        String result = instance.createMessageHash(messageID, messageNumber, messageText);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of SentMessage method, of class Messages.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Messages instance = new Messages();
        String expResult = "";
        String result = instance.SentMessage();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of printMessages method, of class Messages.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Messages instance = new Messages();
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
