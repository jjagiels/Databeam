/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr122u;

/**
 *
 * @author justin
 */
public class cAPDU {
        public static byte[] testTest = { (byte) 0xff, //Class
            (byte) 0xd6, //INS
            (byte) 0x00, //P1
            (byte) 0x00, //P2 = Block number
            (byte) 0x10, // Lc = Number of bytes to update
            //Data to be written
            (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00 };
	
	public static byte[] testHello = { (byte) 0x00, //Class
            (byte) 0x02,//INS
            (byte) 0x00, //P1
            (byte) 0x10};//P2 = Block number
            //(byte) 0x0}; // Lc = Number of bytes to update
            //Data to be written
           // (byte)0x44, (byte)0x44, (byte)0x44,[] (byte)0x44,
            //(byte)0x44, (byte)0x44, (byte)0x44, (byte)0x44 };
	
	public static byte[] selectTestJavaApplet ={ (byte) 0x00, //Class
            (byte) 0xA4,//INS
            (byte) 0x04, //P1
            (byte) 0x00, //P2 = Block number
            (byte) 0x05, // Lc = Number of bytes to update
            //Data to be written
            (byte)0xF0, (byte)0x00, (byte)0x00, (byte)0x00,
            (byte)0x01};
	
}