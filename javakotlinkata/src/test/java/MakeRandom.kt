package com.hertz.consumerrental

//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.data.geo.Metric
import com.example.javakotlinkata.monopoly.models.Player
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.time.*
import java.util.*
import kotlin.random.Random
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType

object ConsumerRentalApiRandom {
//    private val logger: Logger = LoggerFactory.getLogger(ConsumerRentalApiRandom::class.java)

    val randomSeed: Long by lazy {
        SimpleDateFormat("MMddyyyy").format(Date()).toLong()
    }

    val random: Random by lazy {
        // Seed will be today's date as an integer (remove leading zero in 01-01-2020 > 1012020)
//        logger.info("Random Seed: $randomSeed")
        val test = Random(randomSeed)
        test
    }

    fun randomBoolean() = random.nextBoolean()

    fun randomChar() = (('A'..'Z') + ('a'..'z')).random(random)

    fun randomString(length: Int = random.nextInt(1, 100)) =
        (1..length).map { randomChar() }.joinToString(separator = "") { "$it" }

    fun randomUuid(): UUID = UUID.randomUUID()

    fun randomDigit(from: Int = 0, until: Int = 9) = random.nextInt(from, until)

    fun randomInt(from: Int = Int.MIN_VALUE, until: Int = Int.MAX_VALUE) = random.nextInt(from, until)

    fun randomLong(from: Long = Long.MIN_VALUE, until: Long = Long.MAX_VALUE) = random.nextLong(from, until)

    fun randomDouble() = random.nextDouble()

    fun randomPhoneNumber() = (1..10).map { randomDigit() }.joinToString(separator = "") { "$it" }

    inline fun <reified T : Enum<T>> randomEnum(): T {
        return T::class.java.enumConstants.random()
    }

    fun randomLocalDateTime(): LocalDateTime {
        return LocalDateTime.of(
            randomLocalDate(), randomLocalTime()
        )
    }

    fun randomLocalDate(): LocalDate {
        val hundredYears: Long = 100 * 365
        return LocalDate.ofEpochDay(
            random.nextLong(-hundredYears, hundredYears)
        )
    }

    fun randomLocalTime(): LocalTime {
        return LocalTime.ofSecondOfDay(
            random.nextLong(
                LocalTime.MIN.toSecondOfDay().toLong(), LocalTime.MAX.toSecondOfDay().toLong()
            )
        )
    }

    fun randomOffsetDateTime(): OffsetDateTime {
        return OffsetDateTime.of(
            randomLocalDateTime(), randomZoneOffset()
        )
    }

    fun randomOffsetTime(): OffsetTime {
        return OffsetTime.of(
            randomLocalTime(), randomZoneOffset()
        )
    }

    fun randomZoneOffset(): ZoneOffset {
        return ZoneOffset.ofHours(
            random.nextInt(-18, 19)
        )
    }

    fun randomZoneId(): ZoneId {
        return ZoneId.of(ZoneId.getAvailableZoneIds().random())
    }

    fun randomZonedDateTime(): ZonedDateTime {
        return ZonedDateTime.of(
            randomLocalDateTime(), randomZoneId()
        )
    }
}

open class MakeRandomInstanceOptions(
    val nullables: Boolean
)

object DefaultMakeRandomInstanceOptions : MakeRandomInstanceOptions(
    nullables = true
)

inline fun <reified T : Any> makeRandomInstanceNonNull(): T {
    return makeRandomInstance(T::class, T::class.createType(), MakeRandomInstanceOptions(nullables = false)) as T
}

inline fun <reified T : Any> makeRandomInstance(
    options: MakeRandomInstanceOptions = DefaultMakeRandomInstanceOptions
): T {
    return makeRandomInstance(T::class, T::class.createType(), options) as T
}

class NoUsableConstructor(message: String) : Error(message)

private var random: Random = ConsumerRentalApiRandom.random

fun makeRandomInstance(type: KType, options: MakeRandomInstanceOptions): Any? {
    return makeRandomInstance(type.classifier as KClass<*>, type, options)
}

fun makeRandomInstance(clazz: KClass<*>, type: KType, options: MakeRandomInstanceOptions): Any? {
    if (type.isMarkedNullable && random.nextBoolean() && options.nullables) {
        return null
    }

    val primitive = makeStandardInstanceOrNull(clazz, type, options)
    if (primitive != null) {
        return primitive
    }

    val constructors = if (clazz.sealedSubclasses.isNotEmpty()) {
        clazz.sealedSubclasses.random(random).constructors
    } else clazz.constructors

    for (constructor in constructors) {
        try {
            val arguments = constructor.parameters
                .map { makeRandomInstance(it.type, options) }
                .toTypedArray()

            return constructor.call(*arguments)
        } catch (e: Throwable) {
            e.printStackTrace()
            // no-op. We catch any possible error here that might occur during class creation
        }
    }

    throw NoUsableConstructor("${clazz.qualifiedName ?: "Unknown"} has no usable constructors from constructors $constructors")
}

private fun makeStandardInstanceOrNull(
    clazz: KClass<*>,
    type: KType,
    options: MakeRandomInstanceOptions
): Any? {
    if (clazz.java.isEnum) {
        val enumConstants = clazz.java.enumConstants
        return enumConstants[random.nextInt(0, enumConstants.size)]
    }

    return when (clazz) {
        Any::class -> "Anything" // We should randomize among some types
        Boolean::class -> random.nextBoolean()
        Short::class -> random.nextBits(15).toShort()
        Int::class -> random.nextInt()
        Long::class -> random.nextLong()
        Float::class -> random.nextFloat()
        Double::class -> random.nextDouble()
        Char::class -> makeRandomChar()
        String::class -> makeRandomString()

        UUID::class -> UUID.randomUUID()
        ByteArray::class -> random.nextBytes(random.nextInt(0, 10))

        LocalDate::class -> ConsumerRentalApiRandom.randomLocalDate()
        LocalTime::class -> ConsumerRentalApiRandom.randomLocalTime()
        LocalDateTime::class -> ConsumerRentalApiRandom.randomLocalDateTime()
        OffsetTime::class -> ConsumerRentalApiRandom.randomOffsetTime()
        OffsetDateTime::class -> ConsumerRentalApiRandom.randomOffsetDateTime()
        ZoneId::class -> ConsumerRentalApiRandom.randomZoneId()
        ZoneOffset::class -> ConsumerRentalApiRandom.randomZoneOffset()
        ZonedDateTime::class -> ConsumerRentalApiRandom.randomZonedDateTime()

        Pair::class -> makeRandomPair(type, options)
        List::class, Collection::class -> makeRandomList(type, options)
        Map::class -> makeRandomMap(type, options)

//        Metric::class -> randomEnum<Metrics>()

        else -> null
    }
}

private fun makeRandomPair(type: KType, options: MakeRandomInstanceOptions): Pair<Any?, Any?> {
    val firstType = type.arguments[0].type!!
    val secondType = type.arguments[1].type!!
    return Pair(
        makeRandomInstance(firstType, options),
        makeRandomInstance(secondType, options)
    )
}

private fun makeRandomList(type: KType, options: MakeRandomInstanceOptions): List<Any?> {
    val numOfElements = random.nextInt(1, 3)
    val elemType = type.arguments[0].type!!
    return (1..numOfElements)
        .map { makeRandomInstance(elemType, options) }
}

private fun makeRandomMap(type: KType, options: MakeRandomInstanceOptions): Map<Any?, Any?> {
    val numOfElements = random.nextInt(3)
    val keyType = type.arguments[0].type!!
    val valType = type.arguments[1].type!!
    val keys = (1..numOfElements)
        .map { makeRandomInstance(keyType, options) }
    val values = (1..numOfElements)
        .map { makeRandomInstance(valType, options) }
    return keys.zip(values).toMap()
}

private fun makeRandomChar() = ('A'..'z').random(random)
private fun makeRandomString() = (1..random.nextInt(1, 20))
    .map { makeRandomChar() }
    .joinToString(separator = "") { "$it" }

class tests {
    @Test
    fun `test`() {
        val player = makeRandomInstanceNonNull<Player>()
        println(player)
    }

}