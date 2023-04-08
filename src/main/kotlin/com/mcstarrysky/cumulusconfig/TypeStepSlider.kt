package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.component.StepSliderComponent
import taboolib.common.util.asList
import taboolib.common5.cint
import taboolib.module.chat.colored
import taboolib.module.configuration.util.asMap

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.TypeStepSlider
 *
 * @author mical
 * @since 2023/4/8 11:11 AM
 */
class TypeStepSlider: Type() {

    private lateinit var keyword: Map<String, Any>

    var element: String? = null

    lateinit var text: String
    lateinit var steps: List<String>
    var defaultStep: Int = 0

    override fun init(keyword: Map<String, Any>) {
        this.keyword = keyword
        this.text = keyword["text"].toString().colored()
        this.steps = (keyword["steps"]?.asList() ?: emptyList()).colored()
        this.defaultStep = keyword["defaultStep"].cint
        this.element = keyword["element"].toString()
    }

    override fun build(): Component {
        return StepSliderComponent.of(text, steps, defaultStep)
    }

    override fun extra(): Map<String, Any?> {
        return keyword["extra"].asMap()
    }
}