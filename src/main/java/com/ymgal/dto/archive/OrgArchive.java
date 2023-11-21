package com.ymgal.dto.archive;

import com.ymgal.dto.ExtensionName;
import com.ymgal.dto.Website;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrgArchive {

    private Integer vndbPid;

    private String orgName;

    private String mainImg;

    private String introduction;

    private String country;

    private LocalDate birthday;

    private List<Website> website;

    private List<ExtensionName> extensionNames;
}
