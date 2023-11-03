import java.io.IOException;
interface WeatherApiProvider {
    WeatherData fetchWeatherData(String city) throws IOException;
}