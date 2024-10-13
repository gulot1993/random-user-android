package com.random.user.screens.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.random.user.data.domain.UserProfile
import com.random.user.screens.profile.components.ProfileScreenContent
import com.random.user.theme.RandomUserAndroidTheme

@Composable
fun ProfileScreen(
    userProfile: UserProfile
) {
    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
       Column(
           modifier = Modifier
               .padding(
                   top = paddingValues.calculateTopPadding() + 24.dp,
                   bottom = paddingValues.calculateBottomPadding() + 24.dp,
                   start = 16.dp,
                   end = 16.dp
               )
       ) {
           ProfileScreenContent(userProfile = userProfile)
       }
    }
}

@Preview(
    showBackground = true
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "dark"
)
@Composable
fun ProfileScreenPreview() {
    RandomUserAndroidTheme {
        ProfileScreen(
            userProfile = UserProfile(
                photo = "",
                completeName = "Mr. John Does",
                completeAddress = "A. Abellana St. Cebu, City",
                email = "test@gmail.com",
                contactNo = listOf("09168667438", "222-2222").joinToString(" / "),
                gender = UserProfile.Companion.Gender.FEMALE,
                age = 24,
                id = "asdsadsad"
            )
        )
    }
}