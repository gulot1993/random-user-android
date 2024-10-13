package com.random.user.screens.users.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.random.user.data.domain.UserProfile
import com.random.user.theme.RandomUserAndroidTheme

@Composable
fun UserItem(
    userProfile: UserProfile,
    onItemClick: (userProfile: UserProfile) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
            onItemClick(userProfile)
        },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.onSurface),
                model = userProfile.photo,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text (
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = userProfile.completeName,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                )
                Text (
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = userProfile.completeAddress,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "dark"
)
@Preview(
    showBackground = true
)
@Composable
fun UserItemPreview() {
    RandomUserAndroidTheme {
        UserItem(
            userProfile = UserProfile(
                photo = "",
                completeName = "Mr. John Doe",
                completeAddress = "A. Abellana St. Cebu, City",
                id = "ASdasdasd"
            ),
            onItemClick = {}
        )
    }
}