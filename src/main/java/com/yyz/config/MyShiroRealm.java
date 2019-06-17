package com.yyz.config;


import com.yyz.entity.SysUser;
import com.yyz.service.SysUserService;
import com.yyz.vo.UserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;


public class MyShiroRealm extends AuthorizingRealm {

    Boolean cachingEnabled=true;

    @Autowired
    private SysUserService userService;



    /**
     * 为用户授权
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        } else {
            //获取前端输入的用户信息，封装为User对象
            SysUser user = (SysUser) getAvailablePrincipal(principalCollection);
//            user不为空
            if (userService.queryById(user.getUserId()) != null) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                //因为addRoles和addStringPermissions方法需要的参数类型是Collection
                //所以先创建两个collection集合
                Collection<String> roles = new HashSet<>();
                Collection<String> stringPermissions = new HashSet<>();

//                UserVO result = userService.getUserVO(user.getUserId());
                UserVO result = userService.getUserVO(user.getUserId());
                //遍历集合
                result.getRoleSet().stream().forEach(RoleVO -> {
                    roles.add(RoleVO.getRoleName());
                    RoleVO.getSysMenuSet().stream().forEach(SysMenu -> stringPermissions.add(SysMenu.getMenuOther()));
                    //为用户授权
                    info.addStringPermissions(stringPermissions);
                });
                //为用户授予角色
                info.addRoles(roles);
                return info;
            } else {
                return null;
            }

        }

    }

    /**
     * 认证登录
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取前端输入的用户名
        //String userName  = usernamePasswordToken.getUsername();
        //根据用户名查询数据库中对应的记录
        SysUser u = userService.getUserByAccount(usernamePasswordToken.getUsername());
        if(u!=null){
            //当前realm对象的nameu
            String realmName = getName();
            //盐值
            ByteSource credentialsSalt = ByteSource.Util.bytes(u.getUserAccount());
            //封装用户信息，构建AuthenticationInfo对象并返回
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(u, u.getUserPassword(),
                    credentialsSalt, realmName);
            return authcInfo;
        }else{
            throw new AuthenticationException("账户不存在");
        }

    }
}

