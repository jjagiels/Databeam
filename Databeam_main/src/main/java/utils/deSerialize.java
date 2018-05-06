package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class deSerialize {

    public static Object DeSerialize(byte[] byteIn) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteIn);
        ObjectInputStream ois = new LookAheadDeserializer(bis);

        Object obj = ois.readObject();
        ois.close();
        bis.close();
        return obj;
    }
}
