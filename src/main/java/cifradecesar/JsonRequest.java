package cifradecesar;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import javax.management.JMRuntimeException;

public class JsonRequest {

	 public JsonObject requestJsonObject(String url) throws IOException {
	        JsonObject json = readJsonFromUrl(url);
	        return json;
	    }

	    private JsonObject readJsonFromUrl(String url) throws IOException, JMRuntimeException {
	        InputStream is = new URL(url).openStream();
	        try {
	            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	            String jsonText = readAll(rd);

	            JsonObject jsonObject = new JsonParser().parse(jsonText).getAsJsonObject();

	            return jsonObject;
	        } finally {
	            is.close();
	        }
	    }

	    private String readAll(Reader rd) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = rd.read()) != -1) {
	            sb.append((char) cp);
	        }
	        return sb.toString();
	    }
}
