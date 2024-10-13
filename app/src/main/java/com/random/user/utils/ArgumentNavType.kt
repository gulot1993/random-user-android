package com.random.user.utils

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

class ArgumentNavType<T> : NavType<T>(isNullableAllowed = true){
    lateinit var klasz: Class<T>
    override fun get(bundle: Bundle, key: String): T? {
        return bundle.getParcelable(key, klasz)
    }

    override fun parseValue(value: String): T {
        klasz = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<T>
        return Gson().fromJson(value, klasz)
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value as Parcelable)
    }
}