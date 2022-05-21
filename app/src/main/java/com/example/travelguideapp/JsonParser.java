package com.example.travelguideapp;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser extends AsyncTask<Object, String, String> {

    private String googlePlacesData;
    private GoogleMap mMap;
    String url;

    @Override
    protected String doInBackground(Object... objects){
        mMap = (GoogleMap)objects[0];
        url = (String)objects[1];

        DownloadURL downloadURL = new DownloadURL();
        try {
            googlePlacesData = downloadURL.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s){

        List<HashMap<String, String>> nearbyPlaceList;
        DataParser parser = new DataParser();
        nearbyPlaceList = parser.parse(s);
        Log.d("nearbyplacesdata","called parse method");
        showNearbyPlaces(nearbyPlaceList);
    }

    private void showNearbyPlaces(List<HashMap<String, String>> nearbyPlaceList)
    {
        for(int i = 0; i < nearbyPlaceList.size(); i++)
        {
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String, String> googlePlace = nearbyPlaceList.get(i);

            String placeName = googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            double lat = Double.parseDouble( googlePlace.get("lat"));
            double lng = Double.parseDouble( googlePlace.get("lng"));

            LatLng latLng = new LatLng( lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : "+ vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }

    private class DownloadURL {
        public String readUrl(String myUrl) throws IOException
        {
            String data = "";
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(myUrl);
                urlConnection=(HttpURLConnection) url.openConnection();
                urlConnection.connect();

                inputStream = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer sb = new StringBuffer();

                String line = "";
                while((line = br.readLine()) != null)
                {
                    sb.append(line);
                }

                data = sb.toString();
                br.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                inputStream.close();
                urlConnection.disconnect();
            }
            Log.d("DownloadURL","Returning data= "+data);

            return data;
        }
    }

    private class DataParser {
        private HashMap<String, String> getPlace(JSONObject googlePlaceJson)
        {
            HashMap<String, String> googlePlaceMap = new HashMap<>();
            String placeName = "--NA--";
            String vicinity= "--NA--";
            String latitude= "";
            String longitude="";
            String reference="";

            Log.d("DataParser","jsonobject ="+googlePlaceJson.toString());


            try {
                if (!googlePlaceJson.isNull("name")) {
                    placeName = googlePlaceJson.getString("name");
                }
                if (!googlePlaceJson.isNull("vicinity")) {
                    vicinity = googlePlaceJson.getString("vicinity");
                }

                latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
                longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");

                reference = googlePlaceJson.getString("reference");

                googlePlaceMap.put("place_name", placeName);
                googlePlaceMap.put("vicinity", vicinity);
                googlePlaceMap.put("lat", latitude);
                googlePlaceMap.put("lng", longitude);
                googlePlaceMap.put("reference", reference);


            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            return googlePlaceMap;

        }
        private List<HashMap<String, String>>getPlaces(JSONArray jsonArray)
        {
            int count = jsonArray.length();
            List<HashMap<String, String>> placelist = new ArrayList<>();
            HashMap<String, String> placeMap = null;

            for(int i = 0; i<count;i++)
            {
                try {
                    placeMap = getPlace((JSONObject) jsonArray.get(i));
                    placelist.add(placeMap);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return placelist;
        }

        public List<HashMap<String, String>> parse(String jsonData)
        {
            JSONArray jsonArray = null;
            JSONObject jsonObject;

            Log.d("json data", jsonData);

            try {
                jsonObject = new JSONObject(jsonData);
                jsonArray = jsonObject.getJSONArray("results");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return getPlaces(jsonArray);
        }
    }
}
