package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.ButtonComponent
import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.util.FormImage
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeButton
 *
 * @author mical
 * @since 2023/4/8 12:26 AM
 */
class TypeButton : Type() {

    private lateinit var keyword: Map<String, Any>

    var element: String? = null

    lateinit var text: String
    lateinit var type: FormImage.Type
    lateinit var data: String

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
        this.type = FormImage.Type.valueOf(keyword["type"].toString())
        this.data = keyword["data"].toString()
        this.element = keyword["element"].toString()
    }

    override fun build(): Component {
        TODO("Please use TypeButton#button()")
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }

    fun button(): ButtonComponent {
        return ButtonComponent.of(text, type, data)
    }
}