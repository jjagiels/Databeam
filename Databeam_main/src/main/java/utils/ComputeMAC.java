package main.java.utils;
// File: src\jsbook\ch3\ComputeMAC.java
import javax.crypto.Mac;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.io.File;
import java.io.FileInputStream;

public class ComputeMAC {
  public static void main(String[] unused) throws Exception{
    File datafile = new File("/Users/kaeini/Desktop/Repository/Databeam/Databeam_main/src/Hello World.txt");
    System.out.println(datafile.exists());

    KeyGenerator kg = KeyGenerator.getInstance("DES");
    kg.init(56); // 56 is the keysize. Fixed for DES
    SecretKey key = kg.generateKey();

    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(key);

    FileInputStream fis = new FileInputStream(datafile);
    byte[] dataBytes = new byte[1024];
    int nread = fis.read(dataBytes);
    while (nread > 0) {
      mac.update(dataBytes, 0, nread);
      nread = fis.read(dataBytes);
    };
  byte[] macbytes = mac.doFinal();
  System.out.println("MAC(in hex):: " + hex.bytesToHex(macbytes));
  }
}