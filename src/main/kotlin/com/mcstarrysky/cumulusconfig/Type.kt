package com.mcstarrysky.cumulusconfig

import org.geysermc.cumulus.component.Component

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.Type
 *
 * @author mical
 * @since 2023/4/7 11:38 PM
 */
abstract class Type {

    abstract fun init(keyword: Map<String, Any>)

    abstract fun build(): Component

    abstract fun extra(): Map<String, Any?>
}