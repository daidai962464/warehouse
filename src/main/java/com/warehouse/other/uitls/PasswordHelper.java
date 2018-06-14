package com.warehouse.other.uitls;

import com.warehouse.core.po.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/1 15:25
 */
public class PasswordHelper {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static void encryptPassword(User user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPswd(),  ByteSource.Util.bytes(user.getMobile()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        user.setPswd(newPassword);

    }
//    public static void main(String[] args) {
//        PasswordHelper passwordHelper = new PasswordHelper();
//        User user = new User();
//        user.setMobile("admin");
//        user.setPswd("admin");
//        passwordHelper.encryptPassword(user);
//        System.out.println(user);
//    }
}