package world;

import exceptions.NegativeCloudIntensity;
import exceptions.NegativeWindSpeedException;

import javax.sound.midi.Soundbank;

public class Weather {
    private Boolean isSunny;
    private Integer cloudsIntensity;
    private Integer temperature;
    private Integer windSpeed;
    private Integer timesInstantiated;

    private static Weather weather;
    private Sun Sun;

    public Weather() {
        this.isSunny = false;
        this.cloudsIntensity = 95;
        this.temperature = 20;
        this.windSpeed = 5;
        Sun = new Sun();
    }

    public static Weather getWeather() {
        if (weather == null) {
            weather = new Weather();
        }
        return weather;
    }

    public Integer getTimesInstantiated() {
        return timesInstantiated;
    }

    public static class Sun {
        public Sun() {
        }
        public void shine() {
            getWeather().isSunny = true;
            System.out.println("Sun is shining.");
        }
        public void heat(Integer temp) {
            getWeather().temperature += temp;
            System.out.println("Temperature has been increased by " + temp + " degrees.");
        }
    }

    public Boolean getIsSunny() {
        return isSunny;
    }

    public void makeSunny() {
        isSunny = true;
    }

    public void reduceCloudsIntensity(Integer n) {
        if (cloudsIntensity - n >= 0) {
            cloudsIntensity -= n;
        }
        else throw new NegativeCloudIntensity("Clouds intensity cannot be negative");
    }

    public Integer getCloudsIntensity() {
        return cloudsIntensity;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        if (windSpeed < 0) {
            throw new NegativeWindSpeedException("Wind speed cannot be negative");
        }
        else {
            System.out.println("Wind speed has been set to " + windSpeed + ".");
            this.windSpeed = windSpeed;
        }
    }

    public Sun getSun() {
        return Sun;
    }

    public void checkStats() {
        System.out.println("Weather. Is sunny: " + getIsSunny() + ", temperature is " + getTemperature() + ", clouds intensity: " + getCloudsIntensity() + ", wind speed: " + getWindSpeed());
    }
}
