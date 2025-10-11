package tat.mukhutdinov.lesson7.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val titleResId: Int,
    val amount: Int,
    @DrawableRes
    val imageResId: Int
)