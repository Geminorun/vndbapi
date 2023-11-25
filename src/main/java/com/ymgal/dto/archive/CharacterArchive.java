package com.ymgal.dto.archive;

import com.ymgal.dto.ExtensionName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CharacterArchive {

    private Integer vndbCid;


    private String name;

    private List<ExtensionName> extensionNames;

    private String introduction;

    private LocalDate birthday;

    private String mainImg;

    //性别： 0=未知 1=男 2=女
    private Integer gender;
}
