package david.com.takeoff.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import david.com.takeoff.R;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

	private TextView mTextMessage;

	MapView mMapView;
	SupportMapFragment mMapFragment;
	GoogleMap mGoogleMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.activity_main_mapview_default);
		mMapFragment.getMapAsync(this);


	}
	private void checkPermission(){
		if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
			mGoogleMap.setMyLocationEnabled(true);
		}
		else{

		}
	}
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mGoogleMap = googleMap;
		LatLng sydney = new LatLng(-33.852, 151.211);
		googleMap.addMarker(new MarkerOptions().position(sydney)
				.title("Marker in Sydney"));
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
		checkPermission();
	}
}
