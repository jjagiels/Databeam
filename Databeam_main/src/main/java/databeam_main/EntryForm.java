package databeam_main;

import acr122u.connectNFC;

import javax.smartcardio.CardException;
import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import dataClasses.directDeposit;
import utils.*;

public class EntryForm {

    private JPanel entryView;
    private JTextArea pleasePlaceYourPhoneTextArea;
    private static byte[] input;
    private static Object inputObject;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EntryForm");
        frame.setContentPane(new EntryForm().entryView);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        directDeposit DD = new directDeposit();

        DD.setFirstName("Matthew");
        DD.setMiddleName("");
        DD.setLastName("Mott");

        DD.setAddress("123 College Ave.");
        DD.setCity("Newark");
        DD.setState("Delaware");
        DD.setZipCode("19717");

        DD.setSaveAcct("123");
        DD.setCheckOrSaving(true);
        DD.setRoutNum("12345");

       /*try{
            input = connectNFC.readNFC();
        } catch(CardException ce){
            ce.printStackTrace();
        } catch(UnsupportedEncodingException uce){
            uce.printStackTrace();
        } */

        /*try{
            inputObject = deSerialize.DeSerialize(input);
        }catch (IOException e) {
            System.out.println("Error Initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        frame.dispose();
        //selectClass.select(inputObject);
        selectClass.select(DD);

    }
}
