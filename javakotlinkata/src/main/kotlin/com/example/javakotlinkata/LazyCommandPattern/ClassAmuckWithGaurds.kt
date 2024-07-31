package com.example.javakotlinkata.LazyCommandPattern

class ClassAmuckWithGaurds(
    private val serviceA: ServiceA,
    private val serviceB: ServiceB,
    private val serviceC: ServiceC,
) {

    fun getThingC(): ThingC? {
        val thingA = serviceA.getThingA()
        if(thingA == null) return null
        val thingB = serviceB.getThingB(thingA)
        if(thingB == null) return null
        return serviceC.getThingC(thingA, thingB)
    }
}