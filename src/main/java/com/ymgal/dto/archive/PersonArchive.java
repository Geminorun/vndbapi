package com.ymgal.dto.archive;


import com.ymgal.dto.ExtensionName;
import com.ymgal.dto.Website;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonArchive {

    private Integer vndbSid;


    private String name;


    private List<ExtensionName> extensionNames;


    private String introduction;

    private String country;

    private LocalDate birthday;


    private List<Website> website;

    private String mainImg;

    //性别： 0=未知 1=男 2=女
    private Integer gender;
}
