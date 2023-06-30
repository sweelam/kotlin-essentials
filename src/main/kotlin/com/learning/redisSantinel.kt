import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import java.util.UUID

fun connect(): Unit {


    val redisClient = RedisClient.create(
        RedisURI.builder()
            .withSentinel("127.0.0.1")
            .withSentinelMasterId("mymaster")
            .build()
    )

    var connection = redisClient.connect()
    val async = connection.async()

    println("Connected to Redis using Redis Sentinel")
    async.set("test2", "this isa value to be pushed" + UUID.randomUUID())


//    val redisClient: RedisClient = RedisClient.create("redis-sentinel://localhost:26379,localhost:6379/0#mymaster")
//    val connection: StatefulRedisConnection<String, String> = redisClient.connect()
//    println("Connected to Redis using Redis Sentinel")
//    val sync = connection.sync()
//    sync.set("test2", "this isa value to be pushed")
//    Thread.sleep(1000*10)

    connection.close()
    redisClient.shutdown()
}


fun main() {
    connect()
}