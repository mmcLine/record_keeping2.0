package com.mmc.security.record.interceptor;

import com.mmc.security.api.vo.enums.PowerGroup;
import com.mmc.security.common.context.BaseContextHandler;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 权限拦截器
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class PermissionsInterceptor implements Interceptor {




    public Object intercept(Invocation invocation) throws Throwable {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();
            if (sql.toLowerCase().contains("select")){
                //用户管理员
                String newsql="";
                //权限类型
                Integer powerGroup=BaseContextHandler.getPowerGroup();
                if(PowerGroup.USER_POWER.getId().equals(powerGroup)){
                    newsql="select * from("+sql+") t where t.crt_user="+BaseContextHandler.getUserID();
                }else if(PowerGroup.DEPT_POWER.getId().equals(powerGroup)){
                    newsql="select * from("+sql+") t where t.dept_id="+BaseContextHandler.getDept();
                }else if(PowerGroup.ORG_POWER.getId().equals(powerGroup)){
                    newsql="select * from("+sql+") t where t.org_id="+BaseContextHandler.getOrg();
                }else {
                    newsql=sql;
                }

                if(!sql.contains("count")){
                    MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
                    ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                    metaObject.setValue("delegate.boundSql.sql", newsql);
                }
            }
        return invocation.proceed();
    }
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }

    public static void main(String[] args) {
        System.out.println(  PowerGroup.DEPT_POWER.ordinal());
    }
}
