package takeflights.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import takeflights.Models.FlightData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class Cacher {
    private final RedisTemplate<String, List<FlightData>> redisTemplate;
    private final long timeoutHours;

    @Autowired
    public Cacher(RedisTemplate<String, List<FlightData>> redisTemplate, @Value("${cache.timeout.hours}") long timeoutHours) {
        this.redisTemplate = redisTemplate;
        this.timeoutHours = timeoutHours;
    }

    public List<FlightData> retrieveCache(String origin, String departureAt) {
        String cacheKey = origin + ":" + departureAt;
        return redisTemplate.opsForValue().get(cacheKey);
    }

    public void storeCache(String origin, String departureAt, List<FlightData> flights) {
        String cacheKey = origin + ":" + departureAt;
        redisTemplate.opsForValue().set(cacheKey, flights, timeoutHours, TimeUnit.HOURS);
    }
}
