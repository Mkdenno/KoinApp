package com.example.koinapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.outlined.BreakfastDining
import androidx.compose.material.icons.outlined.Receipt
import androidx.compose.material.icons.outlined.Sell
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koinapp.R
import com.example.koinapp.ui.theme.KoinAppTheme
import com.example.koinapp.ui.theme.blue



val dummyKoinList= listOf(
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "Etheurum",
        "ETH",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "USDT",
        "USDT",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    ),
    Koin(
        R.drawable.cooker,
        "BitCoin",
        "BTC",
        "60,000",
        "0.55"
    )


)

@Composable
fun HomeScreen(
    modifier: Modifier=Modifier
) {

    Box (
        modifier=Modifier
            .fillMaxSize()
    ){
        Column {
            HomeTopBar(
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    BalanceCard()

                }
                item {
                    ActionSection()
                }
                items(dummyKoinList){Koin->
                    koinItem(koin = Koin)
                    
                }
            }
        }

    }
    
}

@Composable
fun HomeTopBar(
    modifier: Modifier=Modifier
) {
    Row (
        modifier= modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text ="Good Morning",
                color= MaterialTheme.colorScheme.onBackground.copy(.5f)
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text ="Alvin Putra",
                style=MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.NotificationsNone, contentDescription =null )

        }


    }

}

data class Koin(
    val img:Int,
    val name:String,
    val symbol:String,
    val price:String,
    val change:String,
)

@Composable
fun koinItem(
    modifier: Modifier=Modifier,
    koin: Koin
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(painter = painterResource(id = koin.img), contentDescription =koin.name )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(text = koin.name,
                fontWeight = FontWeight.Bold
                )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = koin.symbol,
                color = MaterialTheme.colorScheme.onBackground.copy(.5f)

            )
        }
        Spacer(modifier = modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(text = "${koin.price}", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "${koin.change}", color = Color.Green)

        }

    }

}


@Composable
fun ActionSection(
    modifier: Modifier =Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ){
        actionList.forEach{(icon, title)->
            ActionItem(icon = icon, title =title )

        }

    }

}

private val actionList= listOf(
    Pair(Icons.Outlined.BreakfastDining, "Buy"),
    Pair(Icons.Outlined.Sell, "Sell"),
    Pair(Icons.Outlined.Send, "Send"),
    Pair(Icons.Outlined.Receipt, "Receive")
)

@Composable
fun ActionItem(
    modifier: Modifier =Modifier,
    icon: ImageVector,
    title:String
) {
    Column (
        modifier=modifier
    ){
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(
                color = blue
            )
        ){
            Icon(imageVector = icon, contentDescription =null,
                modifier=Modifier.padding(8.dp),
                tint=Color.White

            )

        }
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.align(Alignment.CenterHorizontally),
        )


    }

}

@Composable
fun BalanceCard(
    modifier: Modifier=Modifier
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black.copy(.5f),
                        Color.Black.copy(.6f),
                        Color.Black.copy(.7f),
                        Color.Black.copy(.8f)
                    )
                ),
                shape = RoundedCornerShape(12.dp)

            )
            .height(
                200.dp
            )
    ){
        
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            
        ) {
            Text(
                text = "Your Balance",
                color=Color.White
                )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "USD 52,500.65",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
                )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
            Box(modifier =Modifier.background(
                color=Color.White.copy(.3f),
                shape= CircleShape
            ) ) {

                Text(
                    text = "Profit $ 5220",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                )
            }

                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White.copy(.3f),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Yield",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "8.96%",
                            color = Color.Green,
                            fontSize = 12.sp
                        )

                    }

                }


            }
        }
    }

}


@Preview(
    showBackground = true,
    heightDp=800,
    widthDp=500
)
@Composable
fun HomeScreenPreview(){
    KoinAppTheme{
        HomeScreen()
    }
}