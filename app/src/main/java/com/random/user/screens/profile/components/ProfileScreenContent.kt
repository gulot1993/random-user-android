package com.random.user.screens.profile.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.random.user.R
import com.random.user.utils.Constants
import com.random.user.data.domain.UserProfile
import com.random.user.theme.Pink80
import com.random.user.theme.Purple40
import com.random.user.theme.RandomUserAndroidTheme

@Composable
fun ProfileScreenContent(
    userProfile: UserProfile
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                Row {
                    Text (
                        modifier = Modifier
                            .wrapContentSize(),
                        text = userProfile.completeName,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black
                    )

                    val isFemale = userProfile.gender == UserProfile.Companion.Gender.FEMALE
                    Image(
                        modifier = Modifier
                            .size(16.dp),
                        painter = painterResource(
                            id = if (isFemale) R.drawable.ic_female else R.drawable.ic_male,
                        ),
                        colorFilter = ColorFilter.tint(
                            if (isFemale) Pink80 else Purple40
                        ),
                        contentDescription = null
                    )
                }
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

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = null
            )

            Text (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = userProfile.email,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.ic_contact),
                contentDescription = null
            )

            Text (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = userProfile.contactNo,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text (
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.dob, userProfile.dateOfBirth.toString(Constants.DATE_FORMAT)),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text (
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.age, userProfile.age.toString()),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
        }
    }
}

@Preview(
    name = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    showBackground = true
)
@Composable
fun ProfileScreenContentPreview() {
    RandomUserAndroidTheme {
        ProfileScreenContent(
            userProfile = UserProfile(
                photo = "",
                completeName = "Mr. John Doe",
                completeAddress = "A. Abellana St. Cebu, City",
                email = "test@gmail.com",
                contactNo = listOf("09168667438", "222-2222").joinToString(" / "),
                gender = UserProfile.Companion.Gender.FEMALE,
                age = 24,
                id = "Asdasd"
            )
        )
    }
}