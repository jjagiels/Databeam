/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr122u;

import utils.hex;

import javax.smartcardio.*;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author justin
 */
public class connectNFC {

    public static Card waitForCard(CardTerminals terminals)
            throws CardException {
        while (true) {
            for (CardTerminal ct : terminals.list(CardTerminals.State.CARD_INSERTION)) {
                return ct.connect("*");
            }
            terminals.waitForChange();
        }
    }

    public static byte[] readNFC() throws CardException, UnsupportedEncodingException {

        TerminalFactory factory = TerminalFactory.getDefault();

        CardTerminals terminals = factory.terminals();

        Card card = connectNFC.waitForCard(terminals);
        card.beginExclusive();

        CardChannel channel = card.getBasicChannel();

        //Send the Command APDU to give our Android app control over the phone's NFC hardware
        channel.transmit(new CommandAPDU(cAPDU.selectDatabeam));

        //initialize the response byte array
        byte[] byteMessage;


        /**
         * This section will request data from the Android app
         */
        ResponseAPDU r = channel.transmit(new CommandAPDU(cAPDU.requestData));

        //Check the status, if anything but STATUS=OK (0x9000 or 0d36864), throw an exception
        if(r.getSW() != 36864){
            throw new CardException("Bad Status");
        }

        //Store only the actual data from the response (ignore the status bytes)
        byteMessage = r.getData();

        card.disconnect(false);

        //return the data(which should always be a serialized object)
        return byteMessage;
    }

}
