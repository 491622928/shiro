package com.yyz;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Application {

    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        String password = "123456";
        int hashIterations = 1;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
