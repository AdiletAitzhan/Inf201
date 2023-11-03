import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class OpenWeatherMapProvider implements WeatherApiProvider {
    private String apiKey;
    private String baseUrl;

    public OpenWeatherMapProvider(String apiKey, String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    @Override
    public WeatherData fetchWeatherData(String city) throws IOException {
        String completeUrl = baseUrl + "appid=" + apiKey + "&q=" + city;
        URL url = new URL(completeUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = connection.getInputStream();
        Scanner scan = new Scanner(inputStream);
        StringBuilder responseData = new StringBuilder();
        while (scan.hasNext()) {
            responseData.append(scan.next());
        }
        scan.close();
        connection.disconnect();

        JsonObject jsonObject = new JsonParser().parse(responseData.toString()).getAsJsonObject();
        double temperature = jsonObject.getAsJsonObject("main").get("temp").getAsDouble() - 273.15;
        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
        String weatherDescription = jsonObject.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("description").getAsString();

        return new WeatherData(temperature, humidity, weatherDescription);
    }
}