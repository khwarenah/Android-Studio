package com.atom.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.atom.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class SkillInfo(
    val name: String,
    val imageResId: Int
)

@Composable
fun Screen(modifier: Modifier = Modifier) {
    val habilidades = listOf(
        SkillInfo("Skill 1", R.drawable.skill_1),
        SkillInfo("Skill 2", R.drawable.skill_2),
        SkillInfo("Skill 3", R.drawable.skill_3)
    )

    val estadisticas = listOf(
        "Class" to "Medic / Watchman",
        "Rarity" to "6 Stars",
        "Faction" to "Rhodes Island",
        "Code Name" to "Kal'tsit - Esperanta"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kaltsit_avatar),
                    contentDescription = "Kal'tsit Esperanta Avatar",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            painter = painterResource(id = R.drawable.medic_class_icon),
                            contentDescription = "Medic Class Icon",
                            tint = Color(0xFF00E676),
                            modifier = Modifier.size(36.dp)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.watchman_branch_icon),
                            contentDescription = "Watchman Branch Icon",
                            tint = Color(0xFF00BFA5),
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Kal'tsit", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00E676))
                    }
                    Text(text = "Esperanta", fontSize = 16.sp, color = Color(0xFF00BFA5))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            AsyncImage(
                model = "https://arknights.wiki.gg/images/Kal%27tsit_-_Esperanta.png?b8fcdd",
                contentDescription = "Kal'tsit Esperanta Art",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(6) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Construction,
                        contentDescription = "Skills",
                        tint = Color(0xFF00E676),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Skills", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00BFA5))
                }

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    habilidades.forEach { skill ->
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = skill.imageResId),
                                    contentDescription = skill.name,
                                    modifier = Modifier.size(60.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = skill.name, fontSize = 14.sp, color = Color(0xFFECEFF1))
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Operator Details",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00BFA5),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

        estadisticas.forEach { (label, value) ->
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = label, fontWeight = FontWeight.SemiBold, color = Color(0xFF90A4AE))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (label == "Faction") {
                            Image(
                                painter = painterResource(id = R.drawable.rhodes_island_logo),
                                contentDescription = "Rhodes Island Logo",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                        }
                        Text(text = value, color = Color(0xFFECEFF1))
                    }
                }
            }
        }
    }
}