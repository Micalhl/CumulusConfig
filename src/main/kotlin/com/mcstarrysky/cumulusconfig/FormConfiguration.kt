package com.mcstarrysky.cumulusconfig

import taboolib.module.configuration.Configuration

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.FormConfiguration
 *
 * @author mical
 * @since 2023/4/8 10:26 AM
 */
class FormConfiguration(internal val source: Configuration) {

    val title: String? by lazy { source.getString("title") }
    val type: FormType by lazy { FormType.valueOf(source.getString("type") ?: error("unknown type")) }
    val content: String? by lazy { source.getString("content") }
    val elements: ElementConfiguration by lazy { ElementConfiguration(this) }
}