package com.matsiuk.mapexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView

class MapsFragment : Fragment() {

    private var mMapView: MapView? = null
    private var mGoogleMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_map, container, false)
        mMapView = view.findViewById(R.id.mapView)
        mMapView?.onCreate(savedInstanceState)
//        MapsInitializer.initialize(requireActivity().applicationContext)
        mMapView?.getMapAsync { googleMap -> mGoogleMap = googleMap }
        return view
    }

    override fun onResume() {
        super.onResume()
        mMapView?.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mMapView!!.onSaveInstanceState(outState)
    }

    override fun onPause() {
        mMapView?.onPause()
        super.onPause()
    }

    override fun onStop() {
        mMapView?.onStop()
        super.onStop()
    }

    override fun onLowMemory() {
        mMapView?.onLowMemory()
        super.onLowMemory()
    }

    override fun onDestroy() {
        mGoogleMap?.clear()
        mGoogleMap = null
        mGoogleMap?.isMyLocationEnabled = false
        mMapView?.onDestroy()
        mMapView?.removeAllViews()
        mMapView = null
        super.onDestroy()
    }
}