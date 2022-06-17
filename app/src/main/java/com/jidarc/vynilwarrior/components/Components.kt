package com.jidarc.vynilwarrior.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.valentinilk.shimmer.shimmer

@Composable
fun VWAppBar(
    title: String,
    icon: ImageVector? = null,
    showProfile: Boolean = true,
    navController: NavController,
    onBackArrowClicked: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (showProfile) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Logo icon",
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .scale(0.9f)
                    )
                }

                icon?.let {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Back Button",
                        modifier = Modifier.clickable { onBackArrowClicked.invoke() }
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Text(
                    text = title,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
            }
        },
        actions = {
            IconButton(onClick = {
                // TODO Perform discogs logout
            }) {
                // TODO perform logout
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {

    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        textStyle = TextStyle(
            fontSize = 18.sp,
            color = MaterialTheme.colors.onBackground
        ),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction
    )
}

@Composable
fun ShimmeringRow(modifier: Modifier = Modifier) {
    val shimmeringItemsModifier = modifier.background(Color.LightGray)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp)
            .shimmer()
    ) {

        Box(
            modifier = shimmeringItemsModifier
                .width(100.dp)
                .height(100.dp)
        )

        Spacer(modifier = modifier.width(16.dp))

        Column(verticalArrangement = Arrangement.Top) {
            Box(
                modifier = shimmeringItemsModifier
                    .width(150.dp)
                    .height(20.dp)
            )
            Spacer(modifier = modifier.height(16.dp))
            Box(
                modifier = shimmeringItemsModifier
                    .width(100.dp)
                    .height(10.dp)
            )
        }
    }
}

@Composable
fun HyperLink(text: String, url: String, modifier: Modifier = Modifier) {
    val hyperlink = buildAnnotatedString {
        val startIndex = 0
        val endIndex = startIndex + text.length

        append(text)

        addStyle(
            style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline),
            start = startIndex,
            end = endIndex
        )

        addStringAnnotation(tag = "URL", annotation = url, start = startIndex, end = endIndex)
    }

    val urlHandler = LocalUriHandler.current

    ClickableText(
        text = hyperlink,
        modifier = modifier,
        onClick = {
            hyperlink.getStringAnnotations("URL", it, it).firstOrNull()
                ?.let { hyperLinkString ->
                    urlHandler.openUri(hyperLinkString.item)
                }
        })
}

@Composable
fun SectionTitleText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, style = MaterialTheme.typography.h6)
}