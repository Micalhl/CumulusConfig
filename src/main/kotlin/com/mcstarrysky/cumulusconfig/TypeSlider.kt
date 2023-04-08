package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.SliderComponent
import taboolib.common5.cfloat
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeSlider
 *
 * @author mical
 * @since 2023/4/8 11:09 AM
 */
class TypeSlider: Type() {

    private lateinit var keyword: Map<String, Any>

    var element: String? = null

    lateinit var text: String
    var min: Float = 0f
    var max: Float = 0f
    var step: Float = 0f
    var defaultValue: Float = 0f

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
        this.min = keyword["min"].cfloat
        this.max = keyword["max"].cfloat
        this.step = keyword["step"].cfloat
        this.defaultValue = keyword["defaultValue"].cfloat
        this.element = keyword["element"].toString()
    }

    override fun build(): Component {
        return SliderComponent.of(text, min, max, step, defaultValue)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }
}