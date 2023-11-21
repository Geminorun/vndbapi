package com.ymgal.dto;

import com.ymgal.dto.archive.CharacterArchive;
import com.ymgal.dto.archive.GameArchive;
import com.ymgal.dto.archive.OrgArchive;
import com.ymgal.dto.archive.PersonArchive;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 包括机构、角色、人物等等的完整游戏档案结果
 */
@Data
public class HarvestResult {

    private String gameUrl;

    private LocalDateTime taskStartTime;

    private Exception error;

    //--- archives ---


    private GameArchive game;


    private OrgArchive org;


    private List<PersonArchive> personList;

    private List<CharacterArchive> characterList;

    private HarvestResult() {
    }

    public static HarvestResult ok(GameArchive game,
                                   OrgArchive org,
                                   List<PersonArchive> personList,
                                   List<CharacterArchive> characterList) {
        HarvestResult result = new HarvestResult();
        result.game = game;
        result.org = org;
        result.personList = personList;
        result.characterList = characterList;
        return result;
    }

    public static HarvestResult error(LocalDateTime start, Exception error) {
        HarvestResult harvestResult = new HarvestResult();
        harvestResult.setTaskStartTime(start);
        harvestResult.setError(error);
        return harvestResult;
    }
}
