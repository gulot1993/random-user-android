package com.random.user.screens.users

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.random.user.R
import com.random.user.data.domain.UserProfile
import com.random.user.screens.users.components.LoadingIndicator
import com.random.user.screens.users.components.TextFieldWithButton
import com.random.user.screens.users.components.UserItem
import com.random.user.screens.users.state.UsersUIState
import com.random.user.theme.Pink40
import com.random.user.theme.Pink80
import com.random.user.theme.Purple40
import com.random.user.theme.RandomUserAndroidTheme
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun UsersScreen(
    onUserClicked: (userProfile: UserProfile) -> Unit,
    viewModel: UsersViewModel = hiltViewModel()
) {
    val usersUIState by viewModel.uiState.collectAsState()
    UsersScreenContent(onUserClicked = onUserClicked, usersUIState = usersUIState, viewModel = viewModel)
}

@Composable
fun UsersScreenContent(
    onUserClicked: (userProfile: UserProfile) -> Unit,
    usersUIState: UsersUIState,
    viewModel: UsersViewModel
) {
    val users = usersUIState.users
    val isLoading = usersUIState.isLoading
    val error = usersUIState.error

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding() + 24.dp,
                    start = 16.dp,
                    bottom = paddingValues.calculateBottomPadding() + 24.dp,
                    end = 16.dp
                )
        ) {
            TextFieldWithButton(
                onButtonClick = viewModel::getUsers
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
            )

            LoadingIndicator(isLoading = isLoading)

            UsersList(users = users, onItemClick = onUserClicked, isLoadingDone = !isLoading)

        }
    }

    if (error.isNotEmpty()) {
        Toast.makeText(LocalContext.current, error, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun UsersList(
    users: List<UserProfile>,
    onItemClick: (user: UserProfile) -> Unit,
    isLoadingDone: Boolean
) {
    if (isLoadingDone && users.isNotEmpty()) {
        Text(
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            text = stringResource(id = R.string.showing_results)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = users, key = { it.uuid }) { userProfile ->
                UserItem(
                    userProfile = userProfile,
                    onItemClick = onItemClick
                )
            }
        }
    }
}

@Preview(
    name = "dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true
)
@Composable
fun UsersScreenPreview() {
    RandomUserAndroidTheme {
        UsersScreen(
            onUserClicked = {}
        )
    }
}