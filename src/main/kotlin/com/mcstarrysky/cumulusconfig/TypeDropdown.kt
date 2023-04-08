package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.DropdownComponent
import taboolib.common.util.asList
import taboolib.common5.cint
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeDropdown
 *
 * @author mical
 * @since 2023/4/8 11:01 AM
 */
class TypeDropdown : Type() {

    private lateinit var keyword: Map<String, Any>

    var element: String? = null

    lateinit var text: String
    lateinit var options: List<String>
    var defaultOption: Int = 0

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString()
        this.options = keyword["options"]?.asList() ?: emptyList()
        this.defaultOption = keyword["defaultOption"].cint
        this.element = keyword["element"].toString()
    }

    override fun build(): Component {
        return DropdownComponent.of(text, options, defaultOption)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }
}