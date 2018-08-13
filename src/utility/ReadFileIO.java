package utility;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadFileIO {
    public static Object readFileDeserialize(String name){
        Object obj=null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))){
            obj = in.readObject();
        }finally{
            return obj;
        }
    }
}
