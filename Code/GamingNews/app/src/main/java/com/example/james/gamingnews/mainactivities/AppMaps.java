package com.example.james.gamingnews.mainactivities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.james.gamingnews.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 16/12/2014.
 */
public class AppMaps extends FragmentActivity {
    private GoogleMap mapVariable;
    private LatLng latlangEkCentre = new LatLng(55.7591402, -4.1883331); //Starting location of map
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        SetUpMap(); //Initiated Set up of map
        AddMarkers();// Adds markers to map
    }
    public void SetUpMap() {
        mapVariable = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mapVariable != null) {
            mapVariable.moveCamera(CameraUpdateFactory.newLatLngZoom(latlangEkCentre, 12));
            mapVariable.setMyLocationEnabled(true);
            mapVariable.getUiSettings().setCompassEnabled(true);
            mapVariable.getUiSettings().setMyLocationButtonEnabled(true);
            mapVariable.getUiSettings().setRotateGesturesEnabled(true); //Various Settings Initiated in Map View
        }
    }
    public void AddMarkers() {
       LatLng pos = new LatLng(55.759596, -4.176913);
       LatLng pos2 = new LatLng(55.820872, -4.341089);
       LatLng pos3 = new LatLng(55.859398, -4.256915); //Marker Locations
        mapVariable.addMarker(new MarkerOptions()
                .title("Game Shop Location")
                .snippet("Ek Shopping Centre")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .position(pos)
                //Marker Details
        );   //Inputs Marker
        mapVariable.addMarker(new MarkerOptions()
                        .title("Game Shop Location")
                        .snippet("Silverburn Shopping Centre")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        .position(pos2)
                //Marker Details
        );//Inputs Marker
        mapVariable.addMarker(new MarkerOptions()
                        .title("Game Shop Location")
                        .snippet("Union Street, Glasgow")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                        .position(pos3)
                //Marker Details
        );//Inputs Marker
        }
    }


