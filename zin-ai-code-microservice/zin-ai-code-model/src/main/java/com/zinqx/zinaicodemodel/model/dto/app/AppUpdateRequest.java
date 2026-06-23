package com.zinqx.zinaicodemodel.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用 更新请求（用户）
 *
 * @author <a href="https://github.com/Zin-QX">程序员果粒</a>
 */
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}

