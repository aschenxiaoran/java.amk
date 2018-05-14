package hx.amk.admin.intercepts.cache;


import hx.amk.infrastructure.aggragateRoots.impl.AggragateRoot;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-100)
@Component
public class CacheAop {

    //region private variables

    @Autowired
    private BaseCache baseCache;


    //endregion

    //region intercept methods

    @Around(value = "@annotation(redisCache)")
    public Object around(ProceedingJoinPoint joinPoint,RedisCache redisCache) throws Throwable{
        String cacheKey=getCacheKey(joinPoint,redisCache);
        switch (redisCache.option()){
            case SEL:
                return select(cacheKey,joinPoint);

            case Add:
                return add(cacheKey,joinPoint);

            case Up:
                return update(cacheKey,joinPoint);

            case DEL:
                return delete(cacheKey,joinPoint);

                default:
                    break;
        }
        return null;
    }

    /*
    * 前置通知
    */
    @Before("@annotation(cache)")
    public void befor(RedisCache cache){
        RedisCache redisCache=cache;
    }

    /*后置通知*/
    @After("@annotation(cache)")
    public void after(RedisCache cache){

    }

    /*异常通知*/
    @AfterThrowing("@annotation(cache)")
    public void  throwss(RedisCache cache){

    }

    /*
    *返回结果通知
    */
    private void  result(){

    }
    //endregion

    //region private methods

    /*
    *查询
    * @param 缓存关键字
    * @param 获取正在执行的方法
    */
    private Object select(String cacheKey, ProceedingJoinPoint joinPoint) {
        Object result=null;
        try{
            Object value=baseCache.getObject(cacheKey);
            if(value==null){
                result=joinPoint.proceed();
                baseCache.setObject(cacheKey,result);
            }
            else {
                result=value;
            }

        }catch (Throwable ex){

        }

        return result;
    }

    private Object add(String cacheKey, ProceedingJoinPoint joinPoint) {
        Object result=null;
        try
        {
            result=joinPoint.proceed();
            baseCache.add(cacheKey,result);

        }catch (Throwable ex){
              //todo log exception
        }
        return result;
    }

    private Object update(String cacheKey, ProceedingJoinPoint joinPoint) {
        Object result=null;
        try{
            result=joinPoint.proceed();
            baseCache.update(cacheKey,result);
        }catch (Throwable ex){
            //todo log exception
        }
        return result;
    }

    private Object delete(String cacheKey, ProceedingJoinPoint joinPoint) {

        Object result=null;
        try
        {
            baseCache.delete(cacheKey);
            result=joinPoint.proceed();
        }
        catch (Throwable ex){
            //todo log exception
        }
        return result;
    }

    private String getCacheKey(ProceedingJoinPoint joinPoint, RedisCache cache) {
        StringBuilder key=new StringBuilder();
        Object[] args=joinPoint.getArgs();
        Object firstArg=args[0];
        if(firstArg instanceof AggragateRoot){
            int id=((AggragateRoot)firstArg).getId();
            key.append("id_").append(id);
        }
        else if(firstArg instanceof Long){
            key.append("id_").append((Long)firstArg);
        }
        else if(firstArg instanceof String){
            key.append("id_").append((String)firstArg);
        }

        String prefix=cache.prefix();
        String redisKey=prefix+key.toString();

        return redisKey;
    }
    //endregion
}
