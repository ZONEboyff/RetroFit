package com.example.retrofit.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import ir.ehsannarmani.compose_charts.models.DrawStyle

@Composable
fun StepsGraphScreen(){
    var totalSteps by remember { mutableStateOf(12761) }
    var averageSteps by remember { mutableStateOf(1417) }

    Column(
        modifier=Modifier.fillMaxSize().background(Color(0xFF632E5A)).padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Steps", fontSize = 30.sp, color = Color.White)
        var isChecked by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (!isChecked) {
                Button(onClick = { isChecked = !isChecked }) {
                    Text("Year", color = Color.White, fontSize = 30.sp)
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text("Month", color = Color.White, fontSize = 30.sp)
            } else {
                Text("Year",color=Color.White, fontSize = 30.sp)
                Spacer(modifier = Modifier.width(50.dp))
                Button(onClick = { isChecked = !isChecked }) {
                    Text("Month", color = Color.White, fontSize = 30.sp)
                }
            }
        }
        Row() {
            Text("Total", color = Color.White, fontSize = 30.sp)
            Spacer(modifier = Modifier.width(100.dp))
            Text("Average", color = Color.White, fontSize = 30.sp)
        }
        Row() {
            Text("$totalSteps ", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("steps", color = Color.White)
            Spacer(modifier = Modifier.width(50.dp))
            Text("$averageSteps ", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text("steps", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("01/2024-12/2024", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
//        if (isChecked) {
//            Image(
//                painter = painterResource(R.drawable.steps_graph2),
//                contentDescription = null,
//                modifier = Modifier.size(width = 500.dp, height = 600.dp)
//            )
//        } else {
//            Image(painterResource(R.drawable.steps_graph1), contentDescription = null, modifier = Modifier.size(width = 500.dp, height = 600.dp))
//        }

        val stepsData = BarChartData(
            chartData = listOf(
                BarData(
                    point = Point(1f, 10f), label = "Jan"
                ) ,
                BarData(
                    point = Point(2f, 10f), label = "Feb"
                ) ,
                BarData(
                    point = Point(3f, 10f), label = "Mar"
                ),
                BarData(
                    point = Point(4f, 10f), label = "Apr"
                ),
                BarData(
                    point = Point(5f, 10f), label = "May"
                ),
                BarData(
                    point = Point(6f, 10f), label = "Jun"
                ),
                BarData(
                    point = Point(7f, 10f), label = "Jul"
                ),
                BarData(
                    point = Point(8f, 10f), label = "Aug"
                ),
                BarData(
                    point = Point(9f, 10f), label = "Sep"
                ),
                BarData(
                    point = Point(10f, 10f), label = "Oct"
                ),
                BarData(
                    point = Point(11f, 10f), label = "Nov"
                ),
                BarData(
                    point = Point(12f, 10f), label = "Dec"
                )
            ),
            barStyle = BarStyle(
                barWidth=3.dp,
                paddingBetweenBars = 16.dp
            ),
            showXAxis = true,
            showYAxis = true,
            backgroundColor = Color(0,0,10),
        )

        BarChart(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            barChartData = stepsData,

        )


    }
}

@Preview(showBackground = true)
@Composable
fun StepsGraphScreenPreview(){
    StepsGraphScreen()
}
