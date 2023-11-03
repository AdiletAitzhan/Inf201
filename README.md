Main Methods

WeatherApp Class
The WeatherApp class contains the main method, which is the entry point of the application.
It does the following:
Takes the API key and base URL for the OpenWeatherMap API.
Prompts the user to enter a city.
Uses the OpenWeatherMapProvider to fetch weather data for the specified city.
Displays the weather data or an error message in case of an exception.

OpenWeatherMapProvider Class
The OpenWeatherMapProvider class implements the WeatherApiProvider interface.
It is responsible for making HTTP requests to the OpenWeatherMap API and parsing the JSON response to extract weather data.

WeatherDataAdapter Class
The WeatherDataAdapter class acts as an adapter for the weather API provider.
 It has methods to get weather data and display it.
getWeatherData(String city): Fetches weather data for the specified city using the provided API provider.
displayWeatherData(WeatherData weatherData): Displays the weather data, including temperature, humidity, and weather description.

WeatherData Class
The WeatherData class is a simple data class that holds weather-related information, including temperature, humidity, and weather description.
