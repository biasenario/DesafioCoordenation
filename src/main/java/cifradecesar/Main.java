package cifradecesar;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.JsonObject;

public class Main {


    private static String filename = "answer.json";
    private static String endpoint = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=3cdab6500f74f673f896d340e448c289c618b838";
    private static String endpointPost = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=3cdab6500f74f673f896d340e448c289c618b838" ;

    public static void main(String[] args) throws IOException {
        JsonObject josnObject = new JsonRequest().requestJsonObject(endpoint);
        JsonWrite jsonFileCreate = new JsonWrite();
        JsonRead file = new JsonRead();

        jsonFileCreate.createJson(josnObject, filename);

        josnObject = file.readFile(filename);

        josnObject = cesarDecrypt(josnObject);

        jsonFileCreate.createJson(josnObject, filename);

        JsonPost sendFile = new JsonPost();
        sendFile.execute(endpointPost, filename);
    }

    private static JsonObject cesarDecrypt(JsonObject jsonObject) {
        String text = jsonObject.get("cifrado").getAsString();
        Integer key = jsonObject.get("numero_casas").getAsInt();
        CriptoCesar criptoCesar = new CriptoCesar(text, key);

        String textDecrypt = criptoCesar.decrypt();
        String textSha1 = DigestUtils.sha1Hex(textDecrypt);

        jsonObject.addProperty("decifrado", textDecrypt);
        jsonObject.addProperty("resumo_criptografico", textSha1);
        return jsonObject;
    }
}
