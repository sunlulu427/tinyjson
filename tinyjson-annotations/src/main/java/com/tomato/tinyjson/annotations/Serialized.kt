package com.tomato.tinyjson.annotations

/**
 * @Author: sunlulu.tomato
 * @Date:   2022/7/20
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Serialized(val value: String)
