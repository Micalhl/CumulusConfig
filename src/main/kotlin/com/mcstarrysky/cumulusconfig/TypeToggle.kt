package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.ToggleComponent
import taboolib.common5.cbool
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeToggle
 *
 * @author mical
 * @since 2023/4/8 11:17 AM
 */
class TypeToggle: Type() {

    private lateinit var keyword: Map<String, Any>

    lateinit var text: String
    var defaultValue: Boolean = false

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
        this.defaultValue = keyword["defaultValue"].cbool
    }

    override fun build(): Component {
        return ToggleComponent.of(text, defaultValue)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }

    override fun element(): String {
        return keyword["element"].toString()
    }
}