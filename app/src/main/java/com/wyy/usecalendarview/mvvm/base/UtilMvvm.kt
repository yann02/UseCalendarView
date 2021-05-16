package com.wyy.usecalendarview.mvvm.base

import java.lang.reflect.ParameterizedType

object UtilMvvm {
    fun <T> getClass(a:Any) : Class<T>{
        return (a.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
    }
}