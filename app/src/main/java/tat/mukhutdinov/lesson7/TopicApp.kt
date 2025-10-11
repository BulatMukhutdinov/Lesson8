package tat.mukhutdinov.lesson7

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tat.mukhutdinov.lesson7.data.DataSource
import tat.mukhutdinov.lesson7.model.Topic
import tat.mukhutdinov.lesson7.ui.theme.AffirmationsTheme

@Composable
fun TopicApp(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.topics + DataSource.topics) { topic ->
            TopicCard(topic = topic)
        }
    }

}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(modifier) {
        Row {
            Image(
                modifier = Modifier.size(68.dp),
                painter = painterResource(topic.imageResId),
                contentDescription = stringResource(topic.titleResId)
            )

            Column(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(topic.titleResId),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                    )

                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = topic.amount.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TopicPreview() {
    AffirmationsTheme {
        TopicApp()
    }
}