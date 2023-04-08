package com.mcstarrysky.cumulusconfig

import org.bukkit.entity.Player
import org.geysermc.cumulus.component.ButtonComponent
import org.geysermc.cumulus.component.Component
import org.geysermc.cumulus.form.CustomForm
import org.geysermc.cumulus.form.ModalForm
import org.geysermc.cumulus.form.SimpleForm
import taboolib.platform.compat.replacePlaceholder
import java.util.function.Function

/**
 * FIXME: 写的有点垃圾
 *
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.Cumulus
 *
 * @author mical
 * @since 2023/4/8 11:47 AM
 */
fun Player.buildModal(config: FormConfiguration, filter: Boolean = true, replacePlaceholder: Boolean = false, elementFunc: Function<List<Type>, List<Any>>): ModalForm.Builder {
    if (config.type == FormType.MODAL) {
        val elements = elementFunc.apply(config.elements.build(filter))
        val modal = ModalForm.builder()
        modal.title((config.title ?: "").also { if (replacePlaceholder) it.replacePlaceholder(this) })
        modal.content((config.content ?: "").also { if (replacePlaceholder) it.replacePlaceholder(this) })
        modal.button1(elements.filterIsInstance<ButtonComponent>()[0].text().also { if (replacePlaceholder) it.replacePlaceholder(this) })
        modal.button1(elements.filterIsInstance<ButtonComponent>()[1].text().also { if (replacePlaceholder) it.replacePlaceholder(this) })
        return modal
    }
    error("incorrect type")
}

fun Player.buildSimple(config: FormConfiguration, filter: Boolean = true, replacePlaceholder: Boolean = false, elementFunc: Function<List<Type>, List<Any>>): SimpleForm.Builder {
    if (config.type == FormType.SIMPLE) {
        val elements = elementFunc.apply(config.elements.build(filter))
        val simple = SimpleForm.builder()
        simple.title((config.title ?: "").also { if (replacePlaceholder) it.replacePlaceholder(this) })
        simple.content((config.content ?: "").also { if (replacePlaceholder) it.replacePlaceholder(this) })
        elements.filterIsInstance<ButtonComponent>().forEach {
            simple.button(it.text().also { if (replacePlaceholder) it.replacePlaceholder(this) }, it.image())
        }
        return simple
    }
    error("incorrect type")
}

fun Player.buildForm(config: FormConfiguration, filter: Boolean = true, replacePlaceholder: Boolean = false, elementFunc: Function<List<Type>, List<Any>>): CustomForm.Builder {
    if (config.type == FormType.CUSTOM) {
        val elements = elementFunc.apply(config.elements.build(filter))
        val custom = CustomForm.builder()
        custom.title((config.title ?: "").also { if (replacePlaceholder) it.replacePlaceholder(this) })
        elements.filterIsInstance<Component>().forEach {
            custom.component(it)
        }
        return custom
    }
    error("incorrect type")
}