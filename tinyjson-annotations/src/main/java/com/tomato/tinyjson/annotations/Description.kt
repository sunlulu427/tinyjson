package com.tomato.tinyjson.annotations

/**
 * @Author: sunlulu.tomato
 * @Date:   2022/7/20
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.BINARY)
annotation class Description(val value: String, val watchers: Array<String> = [])
