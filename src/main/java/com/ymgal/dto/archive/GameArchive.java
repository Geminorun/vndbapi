package com.ymgal.dto.archive;

import com.ymgal.dto.ExtensionName;
import com.ymgal.dto.Website;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GameArchive {

    /**
     * vndb的ID
     */
    private Integer vndbId;

    /**
     * 开发商ID
     * vndb的pid
     */
    private Integer developer;

    /**
     * 是否有汉化
     */
    private Boolean haveChinese;

    /**
     * 游戏类型描述
     */
    private String typeDesc;

    private String name;

    /**
     * 拓展名称
     */
    private List<ExtensionName> extensionName;

    /**
     * 简介，富文本
     */
    private String introduction;

    private String mainImg;

    private LocalDate releaseDate;

    private Boolean restricted;

    /**
     * 相关网站
     */
    private List<Website> website;

    private List<Characters> characters;

    private List<Release> releases;

    private List<Staff> staff;

    @Data
    @AllArgsConstructor
    public class Release {

        /**
         * 发布的名称
         */
        private String releaseName;

        /**
         * 发布链接
         */
        private String relatedLink;

        /**
         * 发布平台
         */
        private String platform;

        /**
         * 发布时间
         */
        private LocalDate releaseDate;

        /**
         * 发布语言
         */
        private String country;

        /**
         * 限制级别
         */
        private String restrictionLevel;
    }

    @Data
    @AllArgsConstructor
    public class Staff {

        /**
         * 人类档案ID _ 对应的vndbSID
         */
        private Integer sid;

        /**
         * 员工参与时使用的名字
         */
        private String empName;

        /**
         * 员工备注
         */
        private String desc;

        /**
         * 岗位职称
         */
        private String jobName;
    }

    @Data
    @AllArgsConstructor
    public class Characters {

        /**
         * 角色ID， vndbCid
         */
        private Integer cid;

        /**
         * 声优的用户ID， vndb的sid vndbSid
         */
        private Integer cvId;

        /**
         * 此角色在此游戏中是什么位置
         * 1=主角
         * 2=配角
         */
        private Integer position;
    }
}
