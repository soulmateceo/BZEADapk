package com.bzead.india.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bzead.india.data.BzeadRepository
import com.bzead.india.theme.BzeadHeaderNavy
import com.bzead.india.theme.BzeadPrimary
import com.bzead.india.theme.TextPrimary
import com.bzead.india.theme.TextSecondary
import com.bzead.india.ui.components.ProductCard
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(
    initialCategoryId: String = "cat_fashion_men",
    onNavigateBack: () -> Unit = {},
    onNavigateToProduct: (String) -> Unit = {},
    onNavigateToSearch: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToWishlist: () -> Unit = {},
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    val mainDepartments by BzeadRepository.mainDepartments.collectAsState()
    val categorySectionsMap by BzeadRepository.categorySectionsMap.collectAsState()
    val allProducts by BzeadRepository.allProducts.collectAsState()
    val wishlistIds by BzeadRepository.wishlistProductIds.collectAsState()
    val cartItems by BzeadRepository.cartItems.collectAsState()

    val cartCount = cartItems.sumOf { it.quantity }
    val wishlistCount = wishlistIds.size

    var selectedDepartmentId by remember {
        mutableStateOf(
            mainDepartments.firstOrNull { it.id == initialCategoryId || it.name.equals(initialCategoryId, ignoreCase = true) }?.id
                ?: mainDepartments.firstOrNull()?.id
                ?: "cat_fashion_men"
        )
    }

    var selectedSubcategoryFilter by remember { mutableStateOf<String?>(null) }
    var sortBy by remember { mutableStateOf("featured") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        BzeadRepository.refreshHomeContent()
    }

    val selectedDepartment = mainDepartments.find { it.id == selectedDepartmentId }
        ?: mainDepartments.firstOrNull()

    val sections = if (selectedDepartment != null) {
        categorySectionsMap[selectedDepartment.id]
            ?: categorySectionsMap[selectedDepartment.name]
            ?: emptyList()
    } else {
        emptyList()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Sleek Myntra Style Top Header Bar
        Surface(
            color = BzeadHeaderNavy,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "CATEGORIES",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White,
                    letterSpacing = 0.5.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                        onClick = onNavigateToSearch,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    IconButton(
                        onClick = onNavigateToWishlist,
                        modifier = Modifier.size(32.dp)
                    ) {
                        BadgedBox(
                            badge = {
                                if (wishlistCount > 0) {
                                    Badge(
                                        containerColor = Color(0xFFEF4444),
                                        contentColor = Color.White
                                    ) {
                                        Text("$wishlistCount", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "Wishlist",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    IconButton(
                        onClick = onNavigateToCart,
                        modifier = Modifier.size(32.dp)
                    ) {
                        BadgedBox(
                            badge = {
                                if (cartCount > 0) {
                                    Badge(
                                        containerColor = Color(0xFFFEF08A),
                                        contentColor = Color(0xFF0F172A)
                                    ) {
                                        Text("$cartCount", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Cart",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }

        // Active Subcategory Filter Header (If filtered)
        if (selectedSubcategoryFilter != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF1F5F9))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Filtered by: ",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                    Text(
                        text = selectedSubcategoryFilter ?: "",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = BzeadPrimary
                    )
                }

                IconButton(
                    onClick = { selectedSubcategoryFilter = null },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear Filter",
                        tint = TextPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Filtered Products View
            val filteredProds = allProducts.filter { prod ->
                prod.title.contains(selectedSubcategoryFilter!!, ignoreCase = true) ||
                prod.category.contains(selectedSubcategoryFilter!!, ignoreCase = true) ||
                selectedDepartment?.name?.let { prod.category.contains(it, ignoreCase = true) } == true
            }

            if (filteredProds.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No products found for $selectedSubcategoryFilter", color = TextSecondary, fontSize = 14.sp)
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredProds) { product ->
                        ProductCard(
                            product = product,
                            isWishlisted = wishlistIds.contains(product.id),
                            onProductClick = { onNavigateToProduct(product.id) },
                            onWishlistToggle = { BzeadRepository.toggleWishlist(product.id) },
                            onAddToCart = {
                                BzeadRepository.addToCart(product)
                                scope.launch {
                                    snackbarHostState.showSnackbar("Added to Bag: ${product.title}")
                                }
                            }
                        )
                    }
                }
            }
        } else {
            // Classic Myntra 2-Pane Split Category Layout
            Row(modifier = Modifier.fillMaxSize()) {

                // LEFT RAIL: Department Sidebar (Fixed 95.dp Width)
                LazyColumn(
                    modifier = Modifier
                        .width(95.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFF1F5F9))
                        .testTag("myntra_category_left_rail")
                ) {
                    items(mainDepartments) { dept ->
                        val isSelected = dept.id == selectedDepartmentId

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(if (isSelected) Color.White else Color(0xFFF1F5F9))
                                .clickable {
                                    selectedDepartmentId = dept.id
                                    selectedSubcategoryFilter = null
                                }
                                .padding(vertical = 10.dp)
                                .testTag("left_rail_dept_${dept.id}")
                        ) {
                            // Left Active Color Bar Indicator
                            if (isSelected) {
                                Box(
                                    modifier = Modifier
                                        .width(4.dp)
                                        .height(48.dp)
                                        .background(Color(0xFF0F172A))
                                        .align(Alignment.CenterStart)
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 6.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                // Circular Department Thumbnail Image
                                Box(
                                    modifier = Modifier
                                        .size(46.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                        .border(
                                            width = if (isSelected) 1.5.dp else 0.5.dp,
                                            color = if (isSelected) Color(0xFF0F172A) else Color(0xFFCBD5E1),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    AsyncImage(
                                        model = dept.iconUrl,
                                        contentDescription = dept.name,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(CircleShape)
                                    )
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = dept.name,
                                    fontSize = 11.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (isSelected) Color(0xFF0F172A) else Color(0xFF64748B),
                                    textAlign = TextAlign.Center,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

                // RIGHT PANEL: Subcategories Sections & 3-Column Grid
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.White)
                        .padding(horizontal = 12.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    if (sections.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Select a category to view items",
                                    color = TextSecondary,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    } else {
                        sections.forEach { section ->
                            // Section Title
                            item {
                                Text(
                                    text = section.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A),
                                    modifier = Modifier.padding(top = 16.dp, bottom = 10.dp)
                                )
                            }

                            // 3-Column Grid of Subcategories
                            item {
                                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                    section.items.chunked(3).forEach { rowItems ->
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            rowItems.forEach { subItem ->
                                                Column(
                                                    modifier = Modifier
                                                        .weight(1f)
                                                        .clip(RoundedCornerShape(8.dp))
                                                        .clickable {
                                                            selectedSubcategoryFilter = subItem.name
                                                        }
                                                        .padding(vertical = 4.dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    // Circular Subcategory Avatar
                                                    Box(
                                                        modifier = Modifier
                                                            .size(54.dp)
                                                            .clip(CircleShape)
                                                            .background(Color(0xFFF1F5F9))
                                                            .border(0.5.dp, Color(0xFFE2E8F0), CircleShape),
                                                        contentAlignment = Alignment.Center
                                                    ) {
                                                        AsyncImage(
                                                            model = subItem.iconUrl.ifBlank { selectedDepartment?.iconUrl ?: "" },
                                                            contentDescription = subItem.name,
                                                            contentScale = ContentScale.Crop,
                                                            modifier = Modifier
                                                                .fillMaxSize()
                                                                .clip(CircleShape)
                                                        )
                                                    }

                                                    Spacer(modifier = Modifier.height(4.dp))

                                                    Text(
                                                        text = subItem.name,
                                                        fontSize = 10.5.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color(0xFF1E293B),
                                                        textAlign = TextAlign.Center,
                                                        maxLines = 2,
                                                        overflow = TextOverflow.Ellipsis
                                                    )
                                                }
                                            }

                                            // Fill empty columns if row has fewer than 3 items
                                            if (rowItems.size < 3) {
                                                repeat(3 - rowItems.size) {
                                                    Spacer(modifier = Modifier.weight(1f))
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

