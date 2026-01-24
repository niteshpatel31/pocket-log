import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lazysloth.pocketlog.R

@Composable
fun LoginScreen( modifier: Modifier = Modifier) {
    var usernameInput by remember {mutableStateOf("")}
    var defaultUsername by remember { mutableStateOf("") }
    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        TextField(
            value = defaultUsername,
            onValueChange = {defaultUsername= it},

            leadingIcon = {
                Icon(painter = painterResource(R.drawable.person_24px),
                contentDescription = null)
                          },
            modifier = modifier
                .width(280.dp),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            label = { R.string.username },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )

        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            shape = RoundedCornerShape(20.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview()
{
    LoginScreen()
}
