package com.keyijie.common.restful;

/**
 * Restful状态码
 */
public class RestCode {
    /**
     * 正常
     */
    public static final int OK = 200;
    /**
     * 参数错误
     */
    public static final int PARAMETER_ERROR = 1001;
    /**
     * 条件不满足
     */
    public static final int PARAMETER_NOT_MEET = 1002;
    /**
     * 对象不存在
     */
    public static final int OBJECT_NULL = 1004;
    /**
     * 对象已存在
     */
    public static final int OBJECT_EXISTED = 1005;
    /**
     * 添加失败
     */
    public static final int ADD_FAILED = 1010;
    /**
     * 更新失败
     */
    public static final int UPDATE_FAILED = 1011;
    /**
     * 删除失败
     */
    public static final int DELETE_FAILED = 1012;
    /**
     * 未登录
     */
    public static final int NOT_LOGGED_IN = 1401;
    /**
     * 内部服务器错误
     */
    public static final int INTERNAL_SERVER_ERROR = 500;
}
