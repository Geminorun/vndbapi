package com.ymgal.model.vo;

import com.ymgal.model.vo.common.*;

import java.util.List;

/**
 * @Auther: lyl
 * @Date: 2023/10/16 10:37
 * @Description:
 */
public class Release extends VoBase {

    public String title;
    public String alttitle;
    public List<String> platforms;
    public String released;
    public Integer minage;
    public Boolean patch;
    public Boolean freeware;
    public Boolean uncensored;
    public Boolean official;
    public Boolean has_ero;
    public List<Integer> resolution;
    public String engine;
    public Integer voiced;
    public String notes;
    public String gtin;
    public String catalog;
    public List<Language> languages;
    public List<Media> media;
    public List<Vns> vns;

    public List<Producer> producers;
    public List<Exlink> extlinks;
}
