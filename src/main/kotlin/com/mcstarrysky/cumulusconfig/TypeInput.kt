package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.InputComponent
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeInput
 *
 * @author mical
 * @since 2023/4/8 12:32 AM
 */
class TypeInput: Type() {

    private lateinit var keyword: Map<String, Any>

    var element: String? = null

    lateinit var text: String
    lateinit var placeholder: String

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
        this.placeholder = keyword["placeholder"].toString().colored()
        this.element = keyword["element"].toString()
    }

    override fun build(): Component {
        return InputComponent.of(text, placeholder)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }
}