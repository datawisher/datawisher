package com.datawisher.plugin.security.password;

import com.datawisher.webframework.core.util.CodecUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * MD5 密码匹配器
 */
public class Md5CredentialsMatcher implements CredentialsMatcher {

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 获取从表单提交过来的密码、明文，尚未通过 MD5 加密
        String submitted = String.valueOf(((UsernamePasswordToken) token).getPassword());
        // 获取数据库中存储的密码，已通过 MD5 加密
        String encrypted = String.valueOf(info.getCredentials());
        return CodecUtil.md5(submitted).equals(encrypted);
    }
}
