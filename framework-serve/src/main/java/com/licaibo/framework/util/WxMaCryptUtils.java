package com.licaibo.framework.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * 微信小程序 AES解密
 * @author licaibo
 * @date 2020-03-12
 * @href https://github.com/Wechat-Group/WxJava/blob/master/weixin-java-miniapp/src/main/java/cn/binarywang/wx/miniapp/util/crypt/WxMaCryptUtils.java
 **/
public class WxMaCryptUtils {


    private static final Charset UTF_8 = StandardCharsets.UTF_8;



    /**
     * AES解密.
     *
     * @param sessionKey    session_key
     * @param encryptedData 消息密文
     * @param ivStr         iv字符串
     */
    public static String decryptAnotherWay(String sessionKey, String encryptedData, String ivStr) {
        byte[] keyBytes = Base64.decodeBase64(sessionKey.getBytes(UTF_8));

        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }

        Security.addProvider(new BouncyCastleProvider());
        Key key = new SecretKeySpec(keyBytes, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            //Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(Base64.decodeBase64(ivStr.getBytes(UTF_8))));
            return new String(cipher.doFinal(Base64.decodeBase64(encryptedData.getBytes(UTF_8))), UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES解密失败！", e);
        }
    }


    public static void main(String[] args) {
        //微信提供的测试数据
        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
        String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
        String iv = "r7BXXKkLb8qrSNn05n0qiA==";
        String decryptAnotherWay = decryptAnotherWay(sessionKey, encryptedData, iv);
        System.out.println(decryptAnotherWay);
    }


}
