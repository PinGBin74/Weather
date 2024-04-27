package com.example.weather.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.constant.Const.Companion.LOADING
import com.example.weather.model.weather.WeatherResult
import com.example.weather.utils.Utils.Companion.buildIcon
import com.example.weather.utils.Utils.Companion.timestampToHumanDate

@Composable
fun WeatherSection(weatherResponse: WeatherResult) {

// title section
    var title = ""
    if (!weatherResponse.name.isNullOrEmpty()) {
        weatherResponse?.name?.let {
            title = it
        }
    } else {
        weatherResponse.coord?.let {
            title = "${it.lat}/${it.lon}"
        }

    }


    //subtitle section

    var subTitle = ""
    val dateVal = (weatherResponse.dt ?: 0)
    subTitle = if (dateVal == 0) LOADING
    else timestampToHumanDate(dateVal.toLong(), "dd-MM-yyyy")


//icon
    var icon=""
    weatherResponse.weather.let {
        if(it!!.size>0){
            icon=if(it[0].icon==null) LOADING else it[0].icon!!

        }
    }
   /* var temp=""
    weatherResponse.main?.let{
    temp="${it.temp} "
    }*/

    WeatherTitleSection(text = title, subText = subTitle, fontSize = 30.sp)
    WeatherImage(icon=icon)
   // WeatherTitleSection(text=temp,subText=descrption, fontSize = 60.sp)


}

@Composable
fun WeatherImage(icon: String) {
    AsyncImage(model = buildIcon(icon), contentDescription =icon,
        modifier = Modifier.width(200.dp).height(200.dp),
        contentScale= ContentScale.FillBounds)
}

@Composable
fun WeatherTitleSection(text: String, subText: String, fontSize: TextUnit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text, fontSize = fontSize, color = Color.White, fontWeight = FontWeight.Bold)
        Text(subText, fontSize = 15.sp, color = Color.White)


    }

}
