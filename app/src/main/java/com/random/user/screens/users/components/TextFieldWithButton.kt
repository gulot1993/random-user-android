package com.random.user.screens.users.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.random.user.R
import com.random.user.theme.Pink40
import com.random.user.theme.Pink80
import com.random.user.theme.RandomUserAndroidTheme

@Composable
fun TextFieldWithButton(
    onButtonClick: (text: Int) -> Unit
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        BasicTextField(
            modifier = Modifier
                .width(200.dp),
            value = text,
            onValueChange = { newText ->
                if (newText.isDigitsOnly()) {
                    text = newText
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = @Composable { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainer)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ){
                    innerTextField()
                }
            },
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.outline)
        )

        OutlinedButton(
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Black,
            ),
            onClick = {
                if (text.isNotEmpty()) {
                    onButtonClick(text.toInt())
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.get_users)
            )
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
fun TextFieldWithButtonPreview() {
    RandomUserAndroidTheme {
        TextFieldWithButton(
            onButtonClick = { }
        )
    }
}