package com.jidarc.vynilwarrior.screens.details.subscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.jidarc.vynilwarrior.R
import com.jidarc.vynilwarrior.components.HyperLink
import com.jidarc.vynilwarrior.components.SectionTitleText
import com.jidarc.vynilwarrior.models.artist.Artist
import com.jidarc.vynilwarrior.models.artist.Member
import com.valentinilk.shimmer.shimmer

@Composable
fun ArtistInfo(
    artist: Artist,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            if (artist.name != null) {
                with(artist) {
                    val imageUrl = images.first { it.type == "primary" }.uri

                    if (imageUrl != null) {
                        Image(
                            painter = rememberImagePainter(data = imageUrl),
                            contentDescription = name
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.ic_vinyl_record),
                            contentDescription = null
                        )
                    }

                    Text(text = name!!)

                    Box(
                        modifier = modifier.border(
                            BorderStroke(
                                width = 1.dp,
                                color = Color.LightGray
                            )
                        )
                    ) {
                        LazyColumn(
                            modifier = modifier
                                .height(100.dp)
                                .padding(2.dp)
                                .fillMaxWidth()
                        ) {
                            items(urls) { url ->
                                HyperLink(text = url, url = url, modifier = modifier.padding(2.dp))
                            }
                        }
                    }

                    if (!realname.isNullOrEmpty()) {
                        Text(text = "Real name: $realname")
                    }

                    if (!profile.isNullOrEmpty()) {
                        SectionTitleText(title = "Profile", modifier = modifier)
                        LazyColumn(
                            modifier = modifier
                                .height(200.dp)
                                .border(
                                    BorderStroke(
                                        width = 1.dp,
                                        color = Color.LightGray
                                    )
                                )
                        ) {
                            item {
                                Text(text = profile!!, modifier = modifier.padding(5.dp))
                            }
                        }
                    }

                    if (members.isNotEmpty()) {
                        Spacer(modifier = modifier.height(16.dp))
                        MembersSection(members = members, modifier = modifier)
                    }
                }
            } else {
                val shimmerModifier = Modifier
                    .shimmer()
                    .background(Color.LightGray)
                Box(
                    modifier = shimmerModifier
                        .height(150.dp)
                        .width(150.dp)
                )
                Spacer(modifier = modifier.height(10.dp))
                Box(
                    modifier = shimmerModifier
                        .height(50.dp)
                        .width(100.dp)
                )
                Spacer(modifier = modifier.height(5.dp))
                Box(
                    modifier = shimmerModifier
                        .height(20.dp)
                        .width(50.dp)
                )
            }
        }
    }
}

@Composable
fun MembersSection(members: ArrayList<Member>, modifier: Modifier = Modifier) {
    SectionTitleText(title = "Members", modifier = modifier)

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        items(members) { member ->
            MemberRow(member = member)
        }
    }
}

@Composable
fun MemberRow(member: Member, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(3.dp),
        shape = MaterialTheme.shapes.large,
        elevation = 7.dp
    ) {
        Row(modifier = modifier.padding(5.dp), verticalAlignment = Alignment.Top) {

            Image(
                painter = if (member.thumbnailUrl?.isNotEmpty() == true) rememberImagePainter(data = member.thumbnailUrl) else painterResource(
                    id = R.drawable.ic_vinyl_record
                ),
                contentDescription = "Cover image",
                modifier = modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .padding(end = 4.dp)
            )

            Column(modifier) {
                member.name?.let {
                    Text(
                        text = it,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6
                    )
                }

                IsActiveText(isActive = member.active)
            }
        }
    }
}

@Composable
fun IsActiveText(isActive: Boolean?, modifier: Modifier = Modifier) {
    val text = if (isActive == true) "Active" else "Inactive"
    val textColor = if (isActive == true) Color.Green else Color.Red
    
    Text(text = text, color = textColor, style = MaterialTheme.typography.caption)
}