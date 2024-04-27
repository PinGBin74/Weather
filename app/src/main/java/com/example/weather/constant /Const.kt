package com.example.weather.constant

class Const {
    companion object{
        val permissions= arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        const val openWeatherMapApiKey="290e7bf9d834b849e2eb07cea39494b5";

        const val colorBg1=0xff08203e;
        const val colorBg2=0xff557c93;

        const val LOADING="Loading..."
        const val NA="N/A"
    }
}