package cifradecesar;

public class CriptoCesar {
	   private String text;
	    private Integer key;

	    public CriptoCesar(String text, Integer key) {
	        this.text = text;
	        this.key = key;
	    }

	    public String getText() {
	        return text;
	    }

	    public Integer getKey() {
	        return key;
	    }

	    public String encrypt() {
	        String textoCifrado = getText().toLowerCase();
	        String text = "";
	        int tamanhoTexto = getText().length();
	        int min = 97;
	        int max = 122;

	        for (int c = 0; c < tamanhoTexto; c++) {
	            int caracter = ((int) textoCifrado.charAt(c));
	            if (caracter < min || caracter > max){
	                text += (char) caracter;
	            }else{
	                int ASCII = ((int) textoCifrado.charAt(c)) + getKey();

	                if (ASCII < min){
	                    ASCII = max - (min - ASCII)+1;
	                }
	                text += (char) ASCII;
	            }
	        }

	        return text;
	    }

	    public String decrypt() {
	        String textoCifrado = getText().toLowerCase();
	        String text = "";
	        int tamanhoTexto = getText().length();
	        int min = 97;
	        int max = 122;

	        for (int c = 0; c < tamanhoTexto; c++) {
	            int caracter = ((int) textoCifrado.charAt(c));
	            if (caracter < min || caracter > max){
	                text += (char) caracter;
	            }else{
	                int ASCII = ((int) textoCifrado.charAt(c)) - getKey();

	                if (ASCII < min){
	                    ASCII = max - (min - ASCII)+1;
	                }
	                text += (char) ASCII;
	            }
	        }

	        return text;
	    }
}
