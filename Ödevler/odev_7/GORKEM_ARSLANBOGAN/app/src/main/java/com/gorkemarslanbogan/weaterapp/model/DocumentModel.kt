package com.gorkemarslanbogan.weaterapp.model

import org.jsoup.select.Elements
import org.w3c.dom.Document

data class DocumentModel(val elements: Elements, val date: String)
