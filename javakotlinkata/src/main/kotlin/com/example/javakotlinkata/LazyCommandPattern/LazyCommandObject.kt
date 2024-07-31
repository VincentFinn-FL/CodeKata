package com.example.javakotlinkata.LazyCommandPattern

class LazyCommandObject(
    val maybeSomeStartingParams: String,
    val serviceA: ServiceA,
    val serviceB: ServiceB,
    val serviceC: ServiceC
) {
    private val thingA: ThingA? by lazy {
        return@lazy serviceA.getThingA()
    }
    private val thingB: ThingB? by lazy {
        if (thingA == null) return@lazy null
        return@lazy serviceB.getThingB(thingA!!)
    }

    private val thingC: ThingC? by lazy {
        if(thingA == null || thingB == null) return@lazy null
        return@lazy serviceC.getThingC(thingA!!, thingB!!)
    }

    fun invoke(): ThingC? {
        val result = thingC
        if(thingA != null)
            doSomeWork(thingA!!)
        return result
    }

    private fun doSomeWork(thingA: ThingA) {

    }
}