package com.jph.myblog.configurer;

import com.jph.myblog.Realm.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Autowired
    private ShiroRealm shiroRealm;

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(5);
        shiroRealm.setCredentialsMatcher(matcher);
        manager.setRealm(shiroRealm);
        return manager;
    }

    /**
     * 配置Shiro内置过滤器拦截范围
     * @return
     */
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        //配置不认证可以访问的资源
//        definition.addPathDefinition();
        //配置需要进行登录认证得拦截范围
//        authc: 表示需要认证(登录)才能使用;(放最后) /**=authc
//        definition.addPathDefinition("/**", "authc");
        return definition;
    }

}
