package com.loc.newsapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R
import com.loc.newsapp.presentation.Dimension.Medium_Padding1
import com.loc.newsapp.presentation.Dimension.Medium_Padding2
import com.loc.newsapp.presentation.onboarding.Page
import com.loc.newsapp.presentation.onboarding.pages
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(Medium_Padding1))
        Text(
            modifier = Modifier.padding(horizontal = Medium_Padding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            modifier = Modifier.padding(horizontal = Medium_Padding2),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPagePreview() {
    NewsAppTheme {
        OnboardingPage(page = pages[0])
    }
}