package com.example.navberrynext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.navberrynext.step3_nav_controller.RootHubController
import com.example.navberrynext.step3_nav_controller.RootHubS3
import com.example.navberrynext.ui.theme.Wbnavberrynext2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wbnavberrynext2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //RootHubS1(
                    //    modifier = Modifier.padding(innerPadding),
                    //)

                    //RootHubS2(
                    //    activity = this,
                    //    modifier = Modifier.padding(innerPadding),
                    //    onRequestFinish = { finish() },
                    //)

                    val controller = RootHubController()
                    RootHubS3(
                        controller = controller,
                        context = this,
                        modifier = Modifier.padding(innerPadding),
                        onRequestFinish = { finish() },
                    )
                }
            }
        }
    }
}