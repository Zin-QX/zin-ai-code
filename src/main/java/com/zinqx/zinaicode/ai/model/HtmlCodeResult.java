package com.zinqx.zinaicode.ai.model;

import jdk.jfr.Description;
import lombok.Data;

@Description("生成 html 代码文件的结果")
@Data
public class HtmlCodeResult {

    @Description("生成的 html 代码")
    private String htmlCode;

    @Description("生成的 html 描述")
    private String description;
}
