package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf<Page>(
    Page(
        "Dummy Title",
        "This is simply dummy text of the printing and typesetting industry",
        R.drawable.onboarding1
    ),
    Page(
        "Dummy Title",
        "This is simply dummy text of the printing and typesetting industry",
        R.drawable.onboarding2
    ),
    Page(
        "Dummy Title",
        "This is simply dummy text of the printing and typesetting industry",
        R.drawable.onboarding3
    ),
)