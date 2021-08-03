package top.plgxs.common.core.annotation;

import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.common.core.constants.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/2 17:42
 */
// Target-表示该注解用于什么地方
@Target({ ElementType.PARAMETER, ElementType.METHOD })
// Retention-表示在什么级别保存该注解信息
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
