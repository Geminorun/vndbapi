package com.ymgal.dto;

import lombok.Data;


@Data
public class ExtensionName {

    /**
     * 名称
     * アイランド、ISLAND
     */
    private String name;

    /**
     * 类型描述，给别人看的
     * 如: 中文译名、英文译名、别名、简称
     * 描述就是中文描述
     */
    private String type;

    /**
     * 备注
     * 跟在名称后面的备注
     */
    private String desc;

    public ExtensionName() {
    }

    public ExtensionName(String name) {
        this.name = name;
    }

    public ExtensionName(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ExtensionName(String name, String type, String desc) {
        this.name = name;
        this.type = type;
        this.desc = desc;
    }
}
