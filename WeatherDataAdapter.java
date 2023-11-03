import java.io.IOException;
import java.text.DecimalFormat;

class WeatherDataAdapter {
    private WeatherApiProvider apiProvider;

    public WeatherDataAdapter(WeatherApiProvider apiProvider) {
        this.apiProvider = apiProvider;
    }

    public WeatherData getWeatherData(String city) throws IOException {
        return apiProvider.fetchWeatherData(city);
    }
    public static void displayWeatherData(WeatherData weatherData) {
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedTemperature = df.format(weatherData.getTemperature());

        System.out.println("Temperature: " + formattedTemperature + "°C");
        System.out.println("Humidity: " + weatherData.getHumidity() + "%");
        System.out.println("Weather description: " + weatherData.getWeatherDescription());
    }
}