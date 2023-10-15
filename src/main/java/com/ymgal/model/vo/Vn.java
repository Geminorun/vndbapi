package com.ymgal.model.vo;

import com.ymgal.model.vo.common.Image;
import com.ymgal.model.vo.common.Tag;
import com.ymgal.model.vo.common.Title;
import lombok.Data;

import java.util.List;

@Data
public class Vn {
    public String id;
    public String title;
    public String alttitle;
    public List<String> aliases;
    public String olang;
    public String devstatus;
    public String released;
    public List<String> languages;
    public List<String> platforms;
    public String length;
    public String length_minutes;
    public String length_votes;
    public String description;
    public String rating;
    public String votecount;
    public Image image;
    public List<Title> titles;
    public List<Tag> tags;

}
