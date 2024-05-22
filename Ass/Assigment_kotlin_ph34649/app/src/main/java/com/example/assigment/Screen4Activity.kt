package com.example.assigment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.assigment.ui.theme.AssigmentTheme

class Screen4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssigmentTheme {
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    text = "Book Store",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier.padding(horizontal = 67.dp, vertical = 10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_shopping_cart_24), contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)

                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp , vertical = 10.dp),
                horizontalArrangement = Arrangement.Center) {
                Column {

                    Text(text = "Truyện Hài")
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Column {

                    Text(text = "Sách Nói ")
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Column {

                    Text(text = "Sách Tiểu Thuyết ")
                }

            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(homeProducts) { product ->
                    ProductItem(product = product)
                }
            }
        }
     BottomToolbar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottomToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ToolbarIcon(iconResId = R.drawable.baseline_home_24, contentDescription = "Icon 1")
        ToolbarIcon(iconResId = R.drawable.baseline_favorite_24, contentDescription = "Icon 2")
        ToolbarIcon(iconResId = R.drawable.baseline_doorbell_24, contentDescription = "Icon 3")
        ToolbarIcon(iconResId = R.drawable.baseline_person_24, contentDescription = "Icon 4")
    }
}

@Composable
fun ToolbarIcon(iconResId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(40.dp)
            .clickable { /* Xử lý sự kiện khi nhấn vào icon */ }
    )
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .clickable { /* Xử lý sự kiện khi nhấn vào sản phẩm */ },
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = rememberImagePainter(product.imageUrl),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = " ${product.currency} ${product.price} ",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray
            )
        )
    }
}

data class Product(
    val name: String,
    val price: Double,
    val currency: String,
    val imageUrl: String
)

val homeProducts = listOf(
    Product(
        name = "Đắc Nhân Tâm",
        price = 30.0,
        currency = "$",
        imageUrl = "https://nxbhcm.com.vn/Image/Biasach/dacnhantam86.jpg"
    ),
    Product(
        name = "Trí Tuệ Do Thái",
        price = 21.0,
        currency = "$",
        imageUrl = "https://bizweb.dktcdn.net/100/197/269/products/tri-tue-do-thai.jpg?v=1510634413673"
    ),
    Product(
        name = "Đời Ngắn Đừng Ngủ Nhiều",
        price = 30.0,
        currency = "$",
        imageUrl = "https://salt.tikicdn.com/ts/product/81/c5/bb/d9756d8b1f20418e78c4c2175fd74563.jpg"
    ),
    Product(
        name = "Nhà Giả Kim",
        price = 20.0,
        currency = "$",
        imageUrl = "https://upload.wikimedia.org/wikipedia/vi/thumb/9/9c/Nh%C3%A0_gi%E1%BA%A3_kim_%28s%C3%A1ch%29.jpg/150px-Nh%C3%A0_gi%E1%BA%A3_kim_%28s%C3%A1ch%29.jpg"
    ),
    Product(
        name = "Quản Lý Thời Gian",
        price = 20.0,
        currency = "$",
        imageUrl = "https://bizweb.dktcdn.net/100/445/986/products/8936066694650-1.jpg?v=1694675255137"
    ),
    Product(
        name = "Cà Phê Sáng cùng Tony ",
        price = 20.0,
        currency = "$",
        imageUrl = "https://nuhado.co/wp-content/uploads/2019/12/ca-phe-cung-tony.jpg"
    )
)
