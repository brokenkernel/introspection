package com.brokenkernel.introspection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.brokenkernel.introspection.ui.theme.IntrospectionTheme
import com.brokenkernel.introspection.view.OuterContentForCoreIntrospection

public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntrospectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OuterContentForCoreIntrospection(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
