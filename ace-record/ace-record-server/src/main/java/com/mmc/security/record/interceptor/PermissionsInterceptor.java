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
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String wheresql="";
                //权限类型
                Integer powerGroup=BaseContextHandler.getPowerGroup();
                if(PowerGroup.USER_POWER.getId().equals(powerGroup)){
                    wheresql="crt_user="+BaseContextHandler.getUserID();
                }else if(PowerGroup.DEPT_POWER.getId().equals(powerGroup)){
                    wheresql="dept_id="+BaseContextHandler.getDept();
                }else if(PowerGroup.ORG_POWER.getId().equals(powerGroup)){
                    wheresql="org_id="+BaseContextHandler.getOrg();
                }
                String newsql = addwhere(sql, wheresql);
                MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
                    ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                    metaObject.setValue("delegate.boundSql.sql", newsql);
                }
        return invocation.proceed();
    }


    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }

    private static String addwhere(String sql,String wheresql){
        if(StringUtils.hasLength(wheresql)){
            String regex="\\bfrom\\s*\\S*";
            Pattern p=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
            Matcher m=p.matcher(sql);
            if(m.find()){
                String word = m.group();
                int index = sql.indexOf(word)+word.length();
                String presql = sql.substring(0,index);
                String aftersql = sql.substring(index);
                String resultsql;
                if(aftersql.contains("where")||aftersql.contains("WHERE")){
                    resultsql=presql+" where "+wheresql+" and "+aftersql.replace("where","").replace("WHERE","");
                }else {
                    resultsql=presql+" where "+wheresql+" "+aftersql;
                }

                return resultsql;
            }
        }
        return sql;
    }

    public static void main(String[] args) {
       String sql="SELECT  crt_time,crt_user,upd_time,upd_user,dept_id,org_id,id,name,amt,trade_date,trade_type,remarks  from trade_order ORDER BY trade_date desc LIMIT 20";
        String addwhere = addwhere(sql, "a=1");
        System.out.println(addwhere);
    }
}
