package com.cxn.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @program: mybatis
 * @description: Mybatis插件案例
 * @author: cxn
 * @create: 2018-04-19 15:52
 * @Version v1.0
 */
@Intercepts({
        @Signature(
                // 指定要拦截的类，只能是Executors,ParameterHandler, ResultSetHandler, StatementHandler 这4个类中的一个
                type = Executor.class,
                // 指定拦截这个类中的哪个方法
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class ExamplePlugin implements Interceptor {
    // 这个是具体的拦截方法
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        // invocation.proceed()就是执行原本的方法，不做拦截，这里可以做环绕增强
        System.out.println("plugin before～");
        Object proceed = invocation.proceed();
        System.out.println("plugin after~");
        return proceed;
    }

    /**
     * 查询接口会打印出4次，打印出来的target对象分别为：
     *      org.apache.ibatis.executor.CachingExecutor
     *      org.apache.ibatis.scripting.defaults.DefaultParameterHandler
     *      org.apache.ibatis.executor.resultset.DefaultResultSetHandler
     *      org.apache.ibatis.executor.statement.RoutingStatementHandler
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("coming into plugin method~"+target.getClass());
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
