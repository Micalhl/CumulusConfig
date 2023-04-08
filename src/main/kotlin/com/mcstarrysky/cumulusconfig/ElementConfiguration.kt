package com.mcstarrysky.cumulusconfig

import taboolib.common.platform.function.warning

/**
 * CumulusConfig
 * com.mcstarrysky.cumulusconfig.ElementConfiguration
 *
 * @author mical
 * @since 2023/4/8 10:32 AM
 */
class ElementConfiguration(private val source: FormConfiguration) {

    fun get(filter: Boolean = true): List<Map<String, Any>> {
        val result = source.source.getMapList("elements").map {
            val map = hashMapOf<String, Any>()
            it.map { map[it.key.toString()] = it.value!! }
            map
        }
        return if (filter) {
            result.filter { ((it["type"] ?: it["=="] ) ?: "") in source.type.getSupportComponentType() }
        } else {
            result
        }
    }

    fun build(filter: Boolean = true): List<Type> {
        return get(filter).map {
            val type = (it["type"] ?: it["=="]).toString().lowercase()
            val typeInstance = CumulusConfig.componentType[type]?.getDeclaredConstructor()?.newInstance()
            if (typeInstance != null) {
                typeInstance.init(it)
            } else {
                warning("Unsupported component type: ${source.source.file!!.nameWithoutExtension} > $type")
            }
            typeInstance!!
        }
    }
}