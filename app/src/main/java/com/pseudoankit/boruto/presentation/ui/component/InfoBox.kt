package com.pseudoankit.boruto.presentation.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.pseudoankit.boruto.R
import com.pseudoankit.boruto.presentation.ui.theme.INFO_ICON_SIZE
import com.pseudoankit.boruto.presentation.ui.theme.SMALL_PADDING
import com.pseudoankit.boruto.presentation.ui.theme.titleColor

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = SMALL_PADDING)
                .size(INFO_ICON_SIZE),
            painter = icon,
            contentDescription = stringResource(R.string.info_icon),
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = titleColor
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun InfoBoxDarkPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = titleColor
    )
}