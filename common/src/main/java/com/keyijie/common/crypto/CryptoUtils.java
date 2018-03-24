package com.keyijie.common.crypto;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * 加密解密工具类
 */
public class CryptoUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * MD5加密，默认UTF-8
     *
     * @param str a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String MD5(final String str) {
        return MD5(str, DEFAULT_CHARSET);
    }

    /**
     * MD5加密
     *
     * @param str     a {@link java.lang.String} object.
     * @param charset a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String MD5(final String str, final String charset) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(charset);
            return MD5(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * MD5加密
     *
     * @param bytes an array of byte.
     * @return a {@link java.lang.String} object.
     */
    public static String MD5(final byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }

    /**
     * BASE64加密
     *
     * @param bytes an array of byte.
     * @return a {@link java.lang.String} object.
     */
    public static String base64Encode(final byte[] bytes) {
        return new String(Base64.encodeBase64String(bytes));
    }

    /**
     * BASE64加密,默认UTF-8
     *
     * @param str a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String base64Encode(final String str) {
        return base64Encode(str, DEFAULT_CHARSET);
    }

    /**
     * BASE64加密
     *
     * @param str     a {@link java.lang.String} object.
     * @param charset a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String base64Encode(final String str, String charset) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(charset);
            return base64Encode(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * BASE64解密,默认UTF-8
     *
     * @param str a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public static String base64Decode(String str) {
        return base64Decode(str, DEFAULT_CHARSET);
    }

    /**
     * BASE64解密
     *
     * @param str     a {@link java.lang.String} object.
     * @param charset 字符编码
     * @return a {@link java.lang.String} object.
     */
    public static String base64Decode(String str, String charset) {
        try {
            byte[] bytes = str.getBytes(charset);
            return new String(Base64.decodeBase64(bytes));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建密钥字节码
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] GeneralKey(String key, String charset) throws Exception {
        byte[] bytes = key.getBytes(charset);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bytes);
        return md.digest();
    }

    /**
     * 构建加解密向量字节码
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] GeneralIv(String key, String charset) throws Exception {
        byte[] bytes = key.getBytes(charset);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        return md.digest();
    }

    public static String encrypt(String str, byte[] key, byte[] iv, String charset) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
        IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = cipher.doFinal(str.getBytes(charset));
        return Base64.encodeBase64String(encrypted);
    }

    public static String decrypt(String str, byte[] key, byte[] iv, String charset) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec _iv = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
        byte[] encrypted = Base64.decodeBase64(str);
        byte[] original = cipher.doFinal(encrypted);
        return new String(original, charset);
    }

    /**
     * AES加密
     *
     * @param str the str
     * @param key the key
     * @return the string
     */
    public static String encryptAES(String str, String key) throws Exception {
        byte[] keyByte = GeneralKey(key, DEFAULT_CHARSET);
        byte[] ivByte = GeneralIv(key, DEFAULT_CHARSET);
        return encrypt(str, keyByte, ivByte, DEFAULT_CHARSET);
    }

    /**
     * AES解密
     *
     * @param str the str
     * @param key the key
     * @return the string
     */
    public static String decryptAES(String str, String key) throws Exception {
        byte[] keyByte = GeneralKey(key, DEFAULT_CHARSET);
        byte[] ivByte = GeneralIv(key, DEFAULT_CHARSET);
        return decrypt(str, keyByte, ivByte, DEFAULT_CHARSET);
    }

    /**
     * AES加密
     *
     * @param str     the str
     * @param key     the key
     * @param charset the charset
     * @return the string
     */
    public static String encryptAES(String str, String key, String charset) throws Exception {
        byte[] keyByte = GeneralKey(key, charset);
        byte[] ivByte = GeneralIv(key, charset);
        return encrypt(str, keyByte, ivByte, charset);
    }

    /**
     * AES解密
     *
     * @param str     the str
     * @param key     the key
     * @param charset the charset
     * @return the string
     */
    public static String decryptAES(String str, String key, String charset) throws Exception {
        byte[] keyByte = GeneralKey(key, charset);
        byte[] ivByte = GeneralIv(key, charset);
        return decrypt(str, keyByte, ivByte, charset);
    }

}
