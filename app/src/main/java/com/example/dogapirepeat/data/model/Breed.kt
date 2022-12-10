package com.example.dogapirepeat.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Breed(val name: String, val imageResource: String) : Parcelable