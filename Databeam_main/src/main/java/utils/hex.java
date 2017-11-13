/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author justin
 */
public class hex {
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
                          for( int i=0; i<hex.length()-1; i+=2 ){

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
}
