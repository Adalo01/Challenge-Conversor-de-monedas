import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

    public Monedas buscaConversion(String monedaBase, String monedaObjetivo, double cantidadMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8074abe905ab6a360a24cb7e/pair/"
                + monedaBase + "/" + monedaObjetivo + "/" + cantidadMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda.");
        }
    }
}
