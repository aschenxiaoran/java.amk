package hx.amk.infrastructure.cache.redis;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class BaseCache {

    private final ConcurrentHashMap<String,Object> cache=new ConcurrentHashMap<String, Object>();

    public synchronized Object getObject(String cacheKey) {
        if(cacheKey==null || cacheKey.length()<=0){
            return null;
        }
        if(cache.containsKey(cacheKey)){
            Object value= cache.get(cacheKey);
            return value;
        }
        return null;
    }

    public void setObject(String cacheKey, Object value) {
        cache.putIfAbsent(cacheKey,value);
    }

    public synchronized void delete(String cacheKey) {

        if(cache.containsKey(cacheKey)){
            cache.remove(cacheKey);
        }

    }

    public synchronized void update(String cacheKey, Object value) {
        if(cache.containsKey(cacheKey)){
            cache.put(cacheKey,value);
        }

    }

    public void add(String cacheKey, Object value) {
        if(!cache.containsKey(cacheKey)){
            return;
        }
        cache.putIfAbsent(cacheKey,value);
    }
}
