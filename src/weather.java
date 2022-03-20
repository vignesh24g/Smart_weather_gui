import java.util.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;
import org.json.*;

public class weather {

    public static void main(String[] args) throws IOException {

        login l1 = new login();
        l1.logi();

        /*
         * String cc = g1.guii(); System.out.println(cc);
         * 
         * System.out.print("Enter the city name:"); String city = sc.nextLine(); String
         * op = ExtractJson(city); System.out.println(op); jsonop(op);
         */

    }
}

class urltojson {
    public String ExtractJson(String city) throws IOException {
        String key = "";
        String createUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key
                + "&units=metric";
        // Creating an URL object
        URL xurl = null;
        try {
            xurl = new URL(createUrl);
        } catch (MalformedURLException e) {
            String error = "Invalid URL";
            return error;
        }
        InputStream is = (InputStream) xurl.getContent();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String jason = sb.toString();
        return jason;
    }
}

class url2tojson {
    public String ExtractJson(String city) throws IOException {
        String key = "";
        String createUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key
                + "&units=metric";
        // Creating an URL object
        URL xurl = null;
        try {
            xurl = new URL(createUrl);
        } catch (MalformedURLException e) {
            String error = "Invalid URL";
            return error;
        }
        InputStream is = (InputStream) xurl.getContent();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String jason = sb.toString();

        JSONObject aa = new JSONObject(jason);
        String lon = Integer.toString(aa.getJSONObject("coord").getInt("lon"));
        String lat = Integer.toString(aa.getJSONObject("coord").getInt("lat"));
        System.out.println(lon + " " + lat);

        String urlx = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon
                + "&exclude=minutely,hourly&appid=" + key + "&units=metric";
        try {
            xurl = new URL(urlx);
        } catch (MalformedURLException e) {
            String error = "Invalid URL";
            return error;
        }
        is = (InputStream) xurl.getContent();

        br = new BufferedReader(new InputStreamReader(is));
        line = null;
        sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        jason = sb.toString();
        return jason;
    }
}

class jsontotext {

    public String[] jsonop(String v) {
        String[] Name = new String[11];
        try {
            JSONObject vi = new JSONObject(v);
            // System.out.println("JSON Object: " + vi);
            Name[0] = (String) vi.get("name");
            int a = vi.getJSONObject("main").getInt("temp");
            Name[1] = Integer.toString(a);
            Name[2] = Integer.toString(vi.getJSONObject("main").getInt("feels_like"));
            Name[3] = Integer.toString(vi.getJSONObject("main").getInt("temp_min"));
            Name[4] = Integer.toString(vi.getJSONObject("main").getInt("temp_max"));
            Name[5] = Integer.toString(vi.getJSONObject("wind").getInt("speed"));
            Name[6] = Integer.toString(vi.getJSONObject("main").getInt("pressure"));
            Name[7] = Integer.toString(vi.getJSONObject("main").getInt("humidity"));

            long sunr_unix = vi.getJSONObject("sys").getLong("sunrise");
            Date sunr = new Date(sunr_unix * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Name[8] = sdf.format(sunr);
            long suns_unix = vi.getJSONObject("sys").getLong("sunset");
            Date suns = new Date(suns_unix * 1000L);
            Name[9] = sdf.format(suns);
            Name[10] = (String) vi.getJSONObject("sys").getString("country");

            return Name;
        } catch (JSONException e) {
            System.out.println("Error " + e.toString());
        }
        return Name;
    }

}

class json2totext {

    public String[] jsonop(String v) {
        String[] Name = new String[25];
        try {
            JSONObject vi = new JSONObject(v);
            // System.out.println("JSON Object: " + vi);
            // Name[0] = (String) vi.get("name");

            Name[0] = Integer.toString(vi.getJSONObject("current").getInt("visibility"));
            Name[1] = Integer.toString(vi.getJSONObject("current").getInt("uvi"));
            Name[2] = Integer.toString(vi.getJSONObject("current").getInt("dew_point"));
            Name[3] = vi.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("description");
            Name[4] = vi.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("main");
            Name[5] = Integer.toString(vi.getJSONObject("current").getInt("temp"));
            Name[6] = Integer.toString(vi.getJSONObject("current").getInt("feels_like"));
            Name[7] = Integer.toString(vi.getJSONObject("current").getInt("humidity"));
            Name[8] = Integer.toString(vi.getJSONObject("current").getInt("clouds"));
            Name[9] = Integer.toString(vi.getJSONArray("daily").getJSONObject(0).getJSONObject("temp").getInt("day"));
            Name[10] = Integer.toString(vi.getJSONArray("daily").getJSONObject(1).getJSONObject("temp").getInt("day"));
            Name[11] = Integer.toString(vi.getJSONArray("daily").getJSONObject(2).getJSONObject("temp").getInt("day"));
            Name[12] = Integer.toString(vi.getJSONArray("daily").getJSONObject(3).getJSONObject("temp").getInt("day"));
            Name[13] = Integer.toString(vi.getJSONArray("daily").getJSONObject(4).getJSONObject("temp").getInt("day"));
            Name[14] = Integer.toString(vi.getJSONArray("daily").getJSONObject(5).getJSONObject("temp").getInt("day"));
            Name[15] = Integer.toString(vi.getJSONArray("daily").getJSONObject(6).getJSONObject("temp").getInt("day"));
            Name[16] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(0).getJSONObject("temp").getInt("night"));
            Name[17] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(1).getJSONObject("temp").getInt("night"));
            Name[18] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(2).getJSONObject("temp").getInt("night"));
            Name[19] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(3).getJSONObject("temp").getInt("night"));
            Name[20] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(4).getJSONObject("temp").getInt("night"));
            Name[21] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(5).getJSONObject("temp").getInt("night"));
            Name[22] = Integer
                    .toString(vi.getJSONArray("daily").getJSONObject(6).getJSONObject("temp").getInt("night"));

            return Name;
        } catch (JSONException e) {
            System.out.println("Error " + e.toString());
        }
        return Name;
    }

}
