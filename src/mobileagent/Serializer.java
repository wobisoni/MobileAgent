package mobileagent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream b = null;
        try {
            b = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(obj);
        }catch(IOException e){
        }
        return b.toByteArray();
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream o = null;
        try{
            ByteArrayInputStream b = new ByteArrayInputStream(bytes);
            o = new ObjectInputStream(b);
        }catch(Exception e){
            
        }
        return o.readObject();
    }

}
