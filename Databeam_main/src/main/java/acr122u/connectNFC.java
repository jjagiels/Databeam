/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr122u;

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

}
