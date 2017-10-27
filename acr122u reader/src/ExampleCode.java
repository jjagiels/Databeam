import javax.smartcardio.*;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.io.ByteArrayOutputStream;


public class ExampleCode {
	static byte[] c1 = { (byte) 0xff, //Class
            (byte) 0xd6, //INS
            (byte) 0x00, //P1
            (byte) 0x00, //P2 = Block number
            (byte) 0x10, // Lc = Number of bytes to update
            //Data to be written
            (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00 };
	
	static byte[] c2 = { (byte) 0x00, //Class
            (byte) 0x01,//INS
            (byte) 0x00, //P1
            (byte) 0x10};//P2 = Block number
            //(byte) 0x0}; // Lc = Number of bytes to update
            //Data to be written
           // (byte)0x44, (byte)0x44, (byte)0x44,[] (byte)0x44,
            //(byte)0x44, (byte)0x44, (byte)0x44, (byte)0x44 };
	
	static byte[] c3 ={ (byte) 0x00, //Class
            (byte) 0xA4,//INS
            (byte) 0x04, //P1
            (byte) 0x00, //P2 = Block number
            (byte) 0x05, // Lc = Number of bytes to update
            //Data to be written
            (byte)0xF0, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x01};
	
	private static Card waitForCard(CardTerminals terminals)
	        throws CardException {
	    while (true) {
	        for (CardTerminal ct : terminals.list(CardTerminals.State.CARD_INSERTION)) {
	            return ct.connect("*");
	        }
	        terminals.waitForChange();
	    }
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	 public static String convertHexToString(String hex){

		  StringBuilder sb = new StringBuilder();
		  StringBuilder temp = new StringBuilder();

		  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
		  for( int i=0; i<hex.length()-5; i+=2 ){

		      //grab the hex in pairs
		      String output = hex.substring(i, (i + 2));
		      //convert hex to decimal
		      int decimal = Integer.parseInt(output, 16);
		      //convert the decimal to character
		      sb.append((char)decimal);

		      temp.append(decimal);
		  }
		  System.out.println("Decimal : " + temp.toString());

		  return sb.toString();
	  }
	 
	public static void main(String[] args) throws CardException, UnsupportedEncodingException {
		
		// show the list of available terminals
        TerminalFactory factory = TerminalFactory.getDefault();
        //List<CardTerminal> terminals = factory.terminals().list();
        CardTerminals terminals = factory.terminals();
        
        
        List<CardTerminal> tempForPrint = terminals.list();
        System.out.println("Terminals: " + tempForPrint.get(0));
        System.out.println("Place phone/card on reader to start");
        
		Card card = waitForCard(terminals);
		
		card.beginExclusive();
		
        // get the first terminal
        //CardTerminal terminal = terminals.get(0);
        
        // establish a connection with the card
        //Card card = terminal.connect("*");
        System.out.println("card: " + card);  
        CardChannel channel = card.getBasicChannel();
        ResponseAPDU r = channel.transmit(new CommandAPDU(c3));
        System.out.println("response: " + r);
        System.out.println(bytesToHex(r.getBytes()));
        System.out.println(convertHexToString(bytesToHex(r.getBytes())));
        
        byte[] byteMessage = r.getBytes();
        
        System.out.println(Arrays.toString(byteMessage));
        
        
        
        r= channel.transmit(new CommandAPDU(c2));
        byteMessage = r.getBytes();
        System.out.println("response: " + r);
        System.out.println(Arrays.toString(byteMessage));
        System.out.println(bytesToHex(byteMessage));
        System.out.println(convertHexToString(bytesToHex(byteMessage)));
        
        
        //String doc = r.getBytes().toString();
		//byte[] bytes = doc.getBytes("UTF-8");
		//String doc2 = new String(bytes, "UTF-8");
		//System.out.println(doc2);
        // disconnect
        card.disconnect(false);
	}

}
