package cifradecesar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonRead {
	 public JsonObject readFile(String filename) throws FileNotFoundException {
	        JsonObject jsonObject = new JsonParser().parse(new FileReader(filename)).getAsJsonObject();
	        return jsonObject;
	    }
}
