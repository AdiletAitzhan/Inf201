import java.io.IOException;
import java.util.Scanner;
public class WeatherApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String apiKey = "7527060fdde5e0906a56655bcac6e658";
        String baseUrl = "http://api.openweathermap.org/data/2.5/weather?";
        System.out.print("City: ");
        String city = scan.nextLine();
        WeatherApiProvider openWeatherMapProvider = new OpenWeatherMapProvider(apiKey, baseUrl);
        WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapter(openWeatherMapProvider);
        try {
            WeatherData weatherData = weatherDataAdapter.getWeatherData(city);
            WeatherDataAdapter.displayWeatherData(weatherData);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
