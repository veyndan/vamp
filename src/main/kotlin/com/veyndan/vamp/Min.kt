package com.veyndan.vamp

@Target(
    AnnotationTarget.TYPE
)
@Retention(AnnotationRetention.RUNTIME)
annotation class Min(
    val value: Long,
)
