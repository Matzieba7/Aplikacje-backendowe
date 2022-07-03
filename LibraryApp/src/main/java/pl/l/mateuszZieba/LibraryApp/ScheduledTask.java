package pl.l.mateuszZieba.LibraryApp;

import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ScheduledTask {
    @Scheduled(fixedRate = 8000)
    public void sayTheJoke() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://geek-jokes.sameerkumar.website/api?format=json"))
//        https://yesno.wtf/api
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body());
        String joke = jsonObject.getString("joke");


        System.out.println("joke: " + joke);
    }
}
