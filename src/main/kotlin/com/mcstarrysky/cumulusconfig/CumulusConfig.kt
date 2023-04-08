package com.mcstarrysky.cumulusconfig

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.CumulusConfig
 *
 * @author mical
 * @since 2023/4/8 10:19 AM
 */
object CumulusConfig {

    val componentType = hashMapOf(
        "button" to TypeButton::class.java,
        "dropdown" to TypeDropdown::class.java,
        "input" to TypeInput::class.java,
        "label" to TypeLabel::class.java,
        "slider" to TypeSlider::class.java,
        "stepslider" to TypeStepSlider::class.java,
        "toggle" to TypeToggle::class.java
    )
}