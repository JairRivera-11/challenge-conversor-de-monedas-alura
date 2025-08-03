import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {

    public ObtenerDatos obtenerDatos(String monedaBase) {
        String apiKey = "d910c01fb05f8e587bf2745f";
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+monedaBase;

        HttpClient usuario = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        ObtenerDatos datos = null;

        try {
            HttpResponse<String> response = usuario
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            datos = gson.fromJson(json, ObtenerDatos.class);

        } catch (IOException | InterruptedException InterruptedException) {
            throw new RuntimeException();
        }
        return datos;
    }
}

