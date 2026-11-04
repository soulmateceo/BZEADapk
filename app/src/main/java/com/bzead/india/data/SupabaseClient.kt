package com.bzead.india.data

import com.bzead.india.model.CountryItem

object SupabaseClient {

    fun fetchCountries(): List<CountryItem> {
        return listOf(
            CountryItem("in", "India", "IN", "INR", "+91"),
            CountryItem("us", "United States", "US", "USD", "+1"),
            CountryItem("ae", "United Arab Emirates", "AE", "AED", "+971"),
            CountryItem("sg", "Singapore", "SG", "SGD", "+65"),
            CountryItem("uk", "United Kingdom", "GB", "GBP", "+44")
        )
    }
}
