package uiForms;

import utils.ConnectDatabase;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>Direct Deposit Form</h1>
 * This class defines the functionality for the Direct Deposit Form.
 *
 * @author Justin Jagielski
 * @version 1.0
 * @since 5/6/18
 * @see uiForms.directDeposit
 *
 */

public class directDeposit {
    private JPanel contentPane;
    private JTextField firstNameField;
    private JTextField middleNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipCodeField;
    private JTextField saveAcctField;
    private JRadioButton checkAcctButton;
    private JRadioButton saveAcctButton;
    private JTextField routNumField;
    private JTextField checkAcctField;
    private JButton acceptButton;
    private JLabel dataSentField;
    private static Connection conn;
    JFrame frame = new JFrame("Direct Deposit");


    public directDeposit(dataClasses.directDeposit obj) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        firstNameField.setText(obj.getFirstName());
        middleNameField.setText(obj.getMiddleName());
        lastNameField.setText(obj.getLastName());

        addressField.setText(obj.getAddress());
        cityField.setText(obj.getCity());
        stateField.setText(obj.getState());
        zipCodeField.setText(obj.getZipCode());

        if(obj.isCheckOrSaving()){ //false = Checking account, true = Savings/MIA/Money Market account
            saveAcctButton.setSelected(true);
            saveAcctField.setText(obj.getSaveAcct());
        } else{
            checkAcctButton.setSelected(true);
            checkAcctField.setText(obj.getCheckAcct());
        }

        routNumField.setText(obj.getRoutNum());


        acceptButton.addActionListener(new ActionListener() {
            /**
             * When accept button is pressed,
             *
             * Open connection to database,
             * Prepare statements based on what was sent through the phone,
             * Update database based on the prepared statements
             * Change 'dataSentField' to alert user of status
             *
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDatabase.connectDatabase(); //Open the connection


                /*
                 * Begin preparing statements
                 */

                /* Prepare the name fields */
                try{
                    String nameInsertString = "INSERT INTO names (firstName, middleName, lastName) value(?, ?, ?)";
                    PreparedStatement nameStmt = conn.prepareStatement(nameInsertString);
                    //stmt.executeUpdate("INSERT INTO names (firstName, middleName, lastName) value(" + nameEntry + ")");

                    nameStmt.setNString(1, firstNameField.getText());
                    nameStmt.setNString(2, middleNameField.getText());
                    nameStmt.setNString(3, lastNameField.getText());

                    nameStmt.executeUpdate();

                }catch(SQLException se){
                    se.printStackTrace();
                }

                /* Prepare the address fields */
                try{
                    String addressInsertString = "INSERT INTO direct_deposit (address, city, state, zip_code) value(?, ?, ?, ?)";
                    PreparedStatement addrStmt = conn.prepareStatement(addressInsertString);

                    addrStmt.setNString(1, addressField.getText());
                    addrStmt.setNString(2, cityField.getText());
                    addrStmt.setNString(3, stateField.getText());
                    addrStmt.setNString(4, zipCodeField.getText());

                    addrStmt.executeUpdate();
                }catch (SQLException se){
                    se.printStackTrace();
                }

                /* Check which radio button is pressed (checkings or savings) and update that field */
                if(checkAcctButton.isSelected()){ //User has selected the checking account
                    try{
                        String checkInsertString = "INSERT INTO account_num (checking, bank_rout) value(?, ?)";
                        PreparedStatement acctStmt = conn.prepareStatement(checkInsertString);

                        acctStmt.setNString(1, checkAcctField.getText());
                        acctStmt.setNString(2, routNumField.getText());

                        acctStmt.executeUpdate();
                    }catch (SQLException se){
                        se.printStackTrace();
                    }
                }else{ //User has selected the savings account
                    try{
                        String saveInsertString = "INSERT INTO account_num (savings, bank_rout) value(?, ?)";
                        PreparedStatement acctStmt = conn.prepareStatement(saveInsertString);

                        acctStmt.setNString(1, saveAcctField.getText());
                        acctStmt.setNString(2, routNumField.getText());

                        acctStmt.executeUpdate();
                    }catch (SQLException se){
                        se.printStackTrace();
                    }
                }

                dataSentField.setText("Data sent");


            }
        });
    }
}
