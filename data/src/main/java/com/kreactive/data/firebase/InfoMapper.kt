package com.kreactive.data.firebase

import com.kreactive.domain.info.info.Info
import java.util.*
import kotlin.collections.ArrayList

internal fun infoMapper(info: InfoFirebase): Info {
    val language = Locale.getDefault().language

    val name: String
    name = if (language == "fr") {
        info.name
    } else {
        info.name_en
    }

    val content: String
    content = if (language == "fr") {
        info.content
    } else {
        info.content_en
    }

    val mam: String
    mam = if (language == "fr") {
        info.mam
    } else {
        info.mam_en
    }

    return Info(info.id, name, info.img, content, mam)
}

internal fun infoListMapper(infos: MutableList<InfoFirebase>): List<Info> {
    val infoList = ArrayList<Info>(infos.size)
    infos.forEach {
        infoList.add(infoMapper(it))
    }
    return infoList
}