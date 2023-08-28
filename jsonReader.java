import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExample {
    public static void main(String[] args) {
        try {
            // Spécifiez l'URL du fichier JSON hébergé sur un site
            String jsonUrl = "https://exemple.com/chemin/vers/votre/fichier.json";

            // Créez une URL à partir de l'URL spécifiée
            URL url = new URL(jsonUrl);

            // Ouvrez une connexion HTTP vers l'URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configurez la requête HTTP
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Vérifiez si la réponse HTTP est réussie
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Échec de la requête HTTP : " + conn.getResponseCode());
            }

            // Créez un BufferedReader pour lire la réponse HTTP
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            // Lisez la réponse ligne par ligne
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }

            // Fermez la connexion HTTP et le BufferedReader
            conn.disconnect();
            br.close();

            // Convertissez le contenu JSON en un objet JSONArray
            JSONArray jsonArray = new JSONArray(jsonContent.toString());

            // Parcourez les objets JSON dans le tableau
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String message = jsonObject.getString("message");

                // Affichez les valeurs dans la console
                System.out.println("Title: " + title);
                System.out.println("Message: " + message);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
