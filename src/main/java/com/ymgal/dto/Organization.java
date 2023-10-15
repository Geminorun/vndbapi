package com.ymgal.dto;

import com.ymgal.dto.common.ExtensionName;
import com.ymgal.dto.common.Website;

import java.util.List;

public class Organization {
    public String vnpid;
    public String org_name;
    public List<ExtensionName> extension_name;
    public String country;
    public List<Website> website;
    public String introduction;
    public String main_img;
    public String birthday;
}
