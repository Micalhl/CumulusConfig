package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.LabelComponent
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeLabel
 *
 * @author mical
 * @since 2023/4/8 11:07 AM
 */
class TypeLabel: Type() {

    private lateinit var keyword: Map<String, Any>

    lateinit var text: String

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
    }

    override fun build(): Component {
        return LabelComponent.of(text)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }

    override fun element(): String {
        return keyword["element"].toString()
    }
}