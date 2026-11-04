package com.bzead.india.data

import com.bzead.india.model.ProductVariant
import com.bzead.india.model.Review

object SampleCatalogData {

    val liveHeroBanners = listOf(
        HeroBanner(
            id = "hero_1",
            imageUrl = "https://images.unsplash.com/photo-1607082348824-0a96f2a4b9da?w=1200&q=80",
            title = "Mega Super Saver Festival",
            subtitle = "Up to 80% Off on Top Electronics & Fashion"
        ),
        HeroBanner(
            id = "hero_2",
            imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=1200&q=80",
            title = "Smart Gadgets & Wearables",
            subtitle = "Latest Tech Arrivals at Unbeatable Prices"
        ),
        HeroBanner(
            id = "hero_3",
            imageUrl = "https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=1200&q=80",
            title = "Trendy Fashion Collection",
            subtitle = "Elevate Your Style with Bzead Premium Range"
        ),
        HeroBanner(
            id = "hero_4",
            imageUrl = "https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f?w=1200&q=80",
            title = "Home & Kitchen Essentials",
            subtitle = "Transform Your Living Space Today"
        )
    )

    val liveAdBanners = listOf(
        AdBanner(
            id = "ad_slot_1",
            imageUrl = "https://images.unsplash.com/photo-1556228720-195a672e8a03?w=1000&q=80",
            title = "Exclusive Audio Tech Sale",
            adSlot = 1
        ),
        AdBanner(
            id = "ad_slot_2",
            imageUrl = "https://images.unsplash.com/photo-1598440947619-2c35fc9aa908?w=1000&q=80",
            title = "Mamaearth Ultra Light Sunscreen Pack",
            adSlot = 2
        ),
        AdBanner(
            id = "ad_slot_3",
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=1000&q=80",
            title = "Premium Headphones Festival",
            adSlot = 3
        )
    )

    val categories = listOf(
        CategoryItem("cat_mobiles", "Mobiles", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=300&q=80", "Hot Deals"),
        CategoryItem("cat_fashion", "Fashion", "https://images.unsplash.com/photo-1489987707025-afc232f7ea0f?w=300&q=80", "Trending"),
        CategoryItem("cat_beauty", "Beauty", "https://images.unsplash.com/photo-1522337360788-8b13dee7a37e?w=300&q=80", "Popular"),
        CategoryItem("cat_electronics", "Electronics", "https://images.unsplash.com/photo-1498049860654-af1a5c566876?w=300&q=80", "Top Rated"),
        CategoryItem("cat_home", "Home", "https://images.unsplash.com/photo-1513694203232-719a280e022f?w=300&q=80", "Essentials"),
        CategoryItem("cat_appliances", "Appliances", "https://images.unsplash.com/photo-1584622650111-993a426fbf0a?w=300&q=80", "Best Price"),
        CategoryItem("cat_grocery", "Grocery", "https://images.unsplash.com/photo-1542838132-92c53300491e?w=300&q=80", "Daily Deals"),
        CategoryItem("cat_footwear", "Footwear", "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=300&q=80", "Styling"),
        CategoryItem("cat_accessories", "Accessories", "https://images.unsplash.com/photo-1523293182086-7651a899d37f?w=300&q=80", "Gadgets")
    )

    val sampleReviews = listOf(
        Review("Amit K.", 5, "Outstanding sound quality and deep bass! Delivered to Delhi in 2 days.", "2 days ago", true),
        Review("Priya S.", 5, "Authentic product at great price. Packaging was super secure.", "5 days ago", true),
        Review("Vikram R.", 4, "Value for money product. Battery life easily lasts full day.", "1 week ago", true)
    )

    val products = listOf(
        Product(
            id = "prod_1",
            title = "Wireless Noise Cancelling Over-Ear Headphones",
            brand = "BZEAD Audio Pro",
            price = 2999.0,
            originalPrice = 6999.0,
            rating = 4.6f,
            ratingCount = 1420,
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600&q=80",
            isFeatured = true,
            isTrending = false,
            isDeal = true,
            category = "Electronics",
            categoryId = "cat_electronics",
            variants = listOf(
                ProductVariant("v1", "Black Edition", 0.0, "Standard", "Black"),
                ProductVariant("v2", "Silver Edition", 200.0, "Standard", "Silver")
            )
        ),
        Product(
            id = "prod_2",
            title = "Smart Fitness Watch with HD AMOLED Display",
            brand = "BZEAD Tech",
            price = 1999.0,
            originalPrice = 4999.0,
            rating = 4.5f,
            ratingCount = 890,
            imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=600&q=80",
            isFeatured = true,
            isTrending = true,
            isDeal = false,
            category = "Electronics",
            categoryId = "cat_electronics",
            variants = listOf(
                ProductVariant("v3", "Midnight Black", 0.0, "44mm", "Black"),
                ProductVariant("v4", "Rose Gold", 100.0, "40mm", "Gold")
            )
        ),
        Product(
            id = "prod_3",
            title = "Mamaearth Ultra Light Indian Sunscreen SPF 50",
            brand = "Mamaearth",
            price = 449.0,
            originalPrice = 599.0,
            rating = 4.8f,
            ratingCount = 3200,
            imageUrl = "https://images.unsplash.com/photo-1598440947619-2c35fc9aa908?w=600&q=80",
            isFeatured = true,
            isTrending = true,
            isDeal = true,
            category = "Beauty",
            categoryId = "cat_beauty"
        ),
        Product(
            id = "prod_4",
            title = "Ergonomic Mesh Swivel Office Chair",
            brand = "BZEAD Living",
            price = 4599.0,
            originalPrice = 8999.0,
            rating = 4.4f,
            ratingCount = 610,
            imageUrl = "https://images.unsplash.com/photo-1580481072645-022f9a6d83d0?w=600&q=80",
            isFeatured = true,
            isTrending = false,
            isDeal = false,
            category = "Home",
            categoryId = "cat_home"
        ),
        Product(
            id = "prod_5",
            title = "Pro Gaming Optical Mouse RGB 12000 DPI",
            brand = "Logitech",
            price = 899.0,
            originalPrice = 1999.0,
            rating = 4.7f,
            ratingCount = 2150,
            imageUrl = "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?w=600&q=80",
            isFeatured = false,
            isTrending = true,
            isDeal = false,
            category = "Electronics",
            categoryId = "cat_electronics"
        ),
        Product(
            id = "prod_6",
            title = "Classic Leather Sneakers for Men",
            brand = "Puma",
            price = 1499.0,
            originalPrice = 3499.0,
            rating = 4.3f,
            ratingCount = 980,
            imageUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600&q=80",
            isFeatured = false,
            isTrending = true,
            isDeal = true,
            category = "Footwear",
            categoryId = "cat_footwear"
        ),
        Product(
            id = "prod_7",
            title = "Stainless Steel Insulated Water Bottle 1L",
            brand = "Milton",
            price = 499.0,
            originalPrice = 999.0,
            rating = 4.6f,
            ratingCount = 1840,
            imageUrl = "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=600&q=80",
            isFeatured = false,
            isTrending = true,
            isDeal = false,
            category = "Home",
            categoryId = "cat_home"
        ),
        Product(
            id = "prod_8",
            title = "Minimalist Waterproof Backpack 25L",
            brand = "Wildcraft",
            price = 1299.0,
            originalPrice = 2999.0,
            rating = 4.5f,
            ratingCount = 1230,
            imageUrl = "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=600&q=80",
            isFeatured = false,
            isTrending = true,
            isDeal = true,
            category = "Accessories",
            categoryId = "cat_accessories"
        )
    )
}
