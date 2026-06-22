package com.zinqx.zinaicode.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用 创建请求
 *
 * @author <a href="https://github.com/Zin-QX">程序员果粒</a>
 */
@Data
public class AppAddRequest implements Serializable {

    /**
     * 应用初始化的 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;
}
