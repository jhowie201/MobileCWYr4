package com.example.james.gamingnews.mainactivities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.james.gamingnews.MapData;
import com.example.james.gamingnews.MapDataDBMgr;
import com.example.james.gamingnews.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by James on 16/12/2014.
 */
public class AppMaps extends FragmentActivity {

    List<MapData> mapDatalst;

    private Marker[] mapDataMarkerList = new Marker [5];
    private GoogleMap mapVariable;
    private float markerColours[] = {210.0f,120.0f,300.0f,330.0f,270.0f};

    private LatLng latlangEkCentre = new LatLng (55.7591402, -4.1883331);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);

        mapDatalst = new ArrayList<>();
        MapDataDBMgr mapDB = new MapDataDBMgr (this,"mapEKFFamous5.s3db",null,1);
        try
        {
            mapDB.dbCreate();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
            mapDatalst = mapDB.allMapData();
        SetUpMap();
        AddMarkers();
    }

    public void SetUpMap()
    {
        mapVariable = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        if(mapVariable !=null){
            mapVariable.moveCamera(CameraUpdateFactory.newLatLngZoom(latlangEkCentre,12));
            mapVariable.setMyLocationEnabled(true);
            mapVariable.getUiSettings().setCompassEnabled(true);
            mapVariable.getUiSettings().setMyLocationButtonEnabled(true);
            mapVariable.getUiSettings().setRotateGesturesEnabled(true);
        }
    }
    public void AddMarkers(){
        MarkerOptions marker;
        MapData mapData;
        String mrkTitle;
        String mrkText;

        for(int i = 0; 1 < mapDatalst.size(); i++){
            mapData = mapDatalst.get(i);
            mrkTitle = mapData.getFirstname() + " " + mapData.getSurname() + "Occupation: " + mapData.getOccupation();
            mrkText = "Star Sign: " + mapData.getStarSign();
            marker = SetMarker (mrkTitle,mrkText,new LatLng(mapData.getLatitude(), mapData.getLongitude()),markerColours[i], true);
            mapDataMarkerList[i] = mapVariable.addMarker(marker);
        }
    }

    public MarkerOptions SetMarker(String title, String snippet, LatLng position, float markerColour, boolean centreAnchor)
    {
        float anchorX;
        float anchorY;

        if(centreAnchor )
        {
            anchorX = 0.5f;
            anchorY = 0.5f;

        }
        else
        {
            anchorX = 0.5f;
            anchorY = 1f;
        }
        MarkerOptions marker = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory
                .defaultMarker(markerColour).anchor(anchorX, anchorY).position(position));
        return marker;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}