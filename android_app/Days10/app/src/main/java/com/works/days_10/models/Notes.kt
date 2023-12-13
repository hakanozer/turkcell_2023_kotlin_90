package com.works.days_10.models


data class NoteKey(
    val key: String,
    val value: Notes
)

data class Notes(
    val password: String? = "",
    val surname: String? = "",
    val name: String? = "",
    val email: String? = "",
)
