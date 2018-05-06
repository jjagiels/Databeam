package uiForms;

import utils.ConnectDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDatabase.connectDatabase();


            }
        });
    }
}
