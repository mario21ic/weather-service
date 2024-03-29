package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/weather")
public class WeatherController {

    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    // @GetMapping("/city")
    // public @ResponseBody String getWeatherForCity(@RequestParam("name") String cityName){
    //     return weatherRepository.findById(cityName).get().getDescription();
    // }

    @GetMapping("/city")
    public @ResponseBody Weather getWeatherForCity(@RequestParam("name") String cityName) {
        return weatherRepository.findById(cityName).map(weather -> {
            weather.setDescription("It's always sunny on Azure Spring Cloud xD");
            weather.setIcon("weather-sunny");
            return weather;
        }).get();
    }
}