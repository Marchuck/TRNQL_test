package trnql.lukmarr.pl.trnql_test;

import android.os.Bundle;
import android.util.Log;

import com.trnql.smart.activity.ActivityEntry;
import com.trnql.smart.base.SmartActivity;
import com.trnql.smart.location.AddressEntry;
import com.trnql.smart.location.LocationEntry;
import com.trnql.smart.weather.WeatherEntry;
import com.trnql.zen.core.AppData;

public class MainActivity extends SmartActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate ");
        getAppData().setApiKey("API_KEY");

        AppData.startAllServices(this);
    }

    @Override
    protected void onDestroy() {
        AppData.stopAllServices(getApplication());
        super.onDestroy();
    }

    @Override
    protected void smartWeatherChange(WeatherEntry weather) {
        super.smartWeatherChange(weather);
        Log.d(TAG, "smartWeatherChange ");
        //unfortunately, weather data is very poor for this location

//        Log.d(TAG, "current conditions description: " + weather.getCurrentConditionsDescriptionAsString());
//        Log.d(TAG, "rain: " + weather.getRainAsString());
//        Log.d(TAG, "feelsLike: " + weather.getFeelsLikeAsString());
//        Log.d(TAG, "forecast: " + weather.getForecastAsString());
//        Log.d(TAG, "hiLo: " + weather.getHiLoAsString());
//        Log.d(TAG, "humidity: " + weather.getHumidityAsString());
//        Log.d(TAG, "sunRise: " + weather.getSunriseAsString());
//        Log.d(TAG, "sunSet: " + weather.getSunsetAsString());
//        Log.d(TAG, "uvIndex: " + weather.getUVIndexAsString());
        Log.d(TAG, "weather summary: " + weather.getWeatherSummaryAsString());
//        Log.d(TAG, "wind: " + weather.getWindAsString());
//        Log.d(TAG, "gustWindSpeed: " + weather.getGustWindSpeed());
//        Log.d(TAG, "normalWindSpeed: " + weather.getNormalWindSpeed());
    }

    @Override
    protected void smartIsHighAccuracy(boolean isHighAcc) {
        super.smartIsHighAccuracy(isHighAcc);
        Log.d(TAG, "smartIsHighAccuracy " + isHighAcc);
    }

    @Override
    protected void smartLatLngChange(LocationEntry location) {
        super.smartLatLngChange(location);
        Log.d(TAG, "smartLatLngChange ");
        Log.d(TAG, "accuracy: " + location.getAccuracy());
        Log.d(TAG, "altitude: " + location.getAltitude());
        Log.d(TAG, "bearing: " + location.getBearing());
        Log.d(TAG, "(lat,lon): (" + location.getLatitude() + "," + location.getLongitude() + ")");
        Log.d(TAG, "speed: " + location.getSpeed());
        Log.d(TAG, "time: " + location.getTime());
    }

    @Override
    protected void smartAddressChange(AddressEntry address) {
        super.smartAddressChange(address);
        Log.d(TAG, "smartAddressChange ");
        Log.d(TAG, "adminArea: " + address.getAdminArea());
        Log.d(TAG, "countryCode: " + address.getCountryCode());
        Log.d(TAG, "countryName: " + address.getCountryName());
        Log.d(TAG, "featureName: " + address.getFeatureName());
        Log.d(TAG, "locality: " + address.getLocality());
        Log.d(TAG, "postalCode: " + address.getPostalCode());
        Log.d(TAG, "premises: " + address.getPremises());
    }

    @Override
    protected void smartActivityChange(ActivityEntry userActivity) {
        super.smartActivityChange(userActivity);
        Log.d(TAG, "smartActivityChange ");

        Log.d(TAG, "flag isInVehicle: " + String.valueOf(userActivity.isInVehicle()));
        Log.d(TAG, "flag isOnBicycle: " + String.valueOf(userActivity.isOnBicycle()));
        Log.d(TAG, "flag isOnFoot: " + String.valueOf(userActivity.isOnFoot()));
        Log.d(TAG, "flag isRunning: " + String.valueOf(userActivity.isRunning()));
        Log.d(TAG, "flag isStill: " + String.valueOf(userActivity.isStill()));
        Log.d(TAG, "flag isTilting: " + String.valueOf(userActivity.isTilting()));
        Log.d(TAG, "flag isWalking: " + String.valueOf(userActivity.isWalking()));

        Log.d(TAG, "activity: " + userActivity.getActivityString());
        Log.d(TAG, "confidence: " + userActivity.getConfidence());
        Log.d(TAG, "timestamp: " + userActivity.getTimestampString());
    }
}
