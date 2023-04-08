package com.mcstarrysky.cumulusconfig

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.FormType
 *
 * @author mical
 * @since 2023/4/8 10:28 AM
 */
enum class FormType {

    MODAL, SIMPLE, CUSTOM;

    fun getSupportComponentType(): List<String> {
        return when (this) {
            MODAL, SIMPLE -> listOf("button")
            CUSTOM -> listOf("dropdown", "input", "toggle", "slider", "label", "stepslider")
        }
    }
}