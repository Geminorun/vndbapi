package com.ymgal.dto;

import com.ymgal.dto.common.Website;

import java.util.List;

public class Archives {

    public String vnid;
    public String vnpid;
    public String name;
    public String extension_name;
    public Boolean have_chinese;
    public String type_desc;
    public String introduction;
    public String main_img;
    public String release_date;
    public Boolean is_restricted;
    public List<Character> characters;
    public List<Release> releases;
    public List<Website> website;
    public List<Staff> staff;

}
