package cifradecesar;

import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWrite {


    public void createJson(JsonObject json, String file) {

        FileWriter writeFile = null;

        try{
            writeFile = new FileWriter(file);
            writeFile.write(json.toString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
