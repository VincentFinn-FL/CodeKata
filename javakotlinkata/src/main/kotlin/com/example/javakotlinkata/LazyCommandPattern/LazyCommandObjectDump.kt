package com.example.javakotlinkata.LazyCommandPattern

interface ServiceA {
    fun getThingA(): ThingA?
}

interface ServiceB {
    fun getThingB(thingA: ThingA): ThingB?
}

interface ServiceC {
    fun getThingC(thingA: ThingA, thingB: ThingB): ThingC
}

data class ThingA(val thingA: String)
data class ThingB(val thingA: String, val thingB: String)
data class ThingC(val thingA: String, val thingB: String, val thingC: String)
