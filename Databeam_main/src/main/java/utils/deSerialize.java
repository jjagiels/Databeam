package utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class deSerialize {

    public deSerialize() {
    }

    public Object DeSerialize(byte[] byteIn) {
        ByteArrayInputStream bis = new ByteArrayInputStream(byteIn);
        ObjectInput in = null;

        try{
            in = new ObjectInputStream(bis);
            Object o = in.readObject();
            return o;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
        finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
