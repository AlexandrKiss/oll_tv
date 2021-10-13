package com.kiss.olltv.other

import com.google.gson.*
import java.lang.reflect.Type

//При сериализации json в RetrofitBuilder меняем 1/0 на true/false
class BooleanTypeAdapter : JsonDeserializer<Boolean?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Boolean? {
        if ((json as JsonPrimitive).isBoolean) {
            return json.getAsBoolean()
        }
        if (json.isString) {
            val jsonValue = json.getAsString()
            return when {
                jsonValue.equals("true", ignoreCase = true) -> true
                jsonValue.equals("false", ignoreCase = true) -> false
                else -> null
            }
        }
        val code = json.getAsInt()
        return if (code == 0) false else if (code == 1) true else null
    }
}