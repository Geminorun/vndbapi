package com.ymgal;

import com.ymgal.dto.ExtensionName;
import com.ymgal.dto.HarvestResult;
import com.ymgal.dto.Website;
import com.ymgal.dto.archive.CharacterArchive;
import com.ymgal.dto.archive.GameArchive;
import com.ymgal.dto.archive.OrgArchive;
import com.ymgal.dto.archive.PersonArchive;
import com.ymgal.filter.VndbFilters;
import com.ymgal.helper.JsonHelper;
import com.ymgal.helper.TcpHelper;
import com.ymgal.model.Character.Character;
import com.ymgal.model.Character.VoiceActorMetadata;
import com.ymgal.model.Producer.Producer;
import com.ymgal.model.Staff.Staff;
import com.ymgal.model.VisualNovel.VisualNovel;
import com.ymgal.model.VndbResponse;
import com.ymgal.modelhttp.VndbFilter;
import com.ymgal.modelhttp.enums.FilterName;
import com.ymgal.modelhttp.enums.FilterOperator;
import com.ymgal.modelhttp.vo.Release;
import com.ymgal.modelhttp.vo.Vn;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class VndbapiApplicationTests {

    /**
     * @param: 获取VN档案
     * @return:
     * @auther: lyl
     * @date: 2023/10/16 15:03
     * 功能描述:
     */
    @Test
    void getVN() {
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        VndbResponse<Vn> vnVndbResponse = VndbGetMethodByHttp.GetVisualNovel(vndbFilter);
        Vn vn = vnVndbResponse.getItems().get(0);
        System.out.println(JsonHelper.serialize(vn));
    }

    /**
     * @param: 获取发售信息
     * @return:
     * @auther: lyl
     * @date: 2023/10/16 15:03
     * 功能描述:
     */
    @Test
    void getRelease() {
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        VndbResponse<Release> responseBody = VndbGetMethodByHttp.getRelease(vndbFilter);
        Release release = responseBody.getItems().get(0);
        System.out.println(JsonHelper.serialize(release));
    }

    @Test
    public GameArchive getGameAcrhive() {

        // HTTP查询数据
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        VndbResponse<Vn> responseBody = VndbGetMethodByHttp.GetVisualNovel(vndbFilter);
        Vn vn = responseBody.getItems().get(0);
        System.out.println(JsonHelper.serialize(vn));


        GameArchive archive = new GameArchive();
        // ID
        archive.setVndbId(Integer.parseInt(vn.getId().replace("v", "")));
        // 标题
        archive.setName(vn.getTitle());

        // 是否有汉化
        archive.setHaveChinese(vn.getLanguages().stream().anyMatch(x -> "zh-Hans".equals(x) | "zh-Hant".equals(x)));
        // 图片
        archive.setMainImg(vn.getImage().getUrl());
        // 游戏类型
        // TODO 没有类型描述字段
        archive.setTypeDesc("");
        // 开发商
        // TODO 有多家开发商
        //archive.setDeveloper();

        // 发售日期
        archive.setReleaseDate(LocalDate.parse(vn.getReleased()));

        // 扩展名
        List<ExtensionName> extensionNames = vn.getTitles().stream().map(x -> {
            return new ExtensionName(x.getTitle(), x.getLang());
        }).collect(Collectors.toList());
        archive.setExtensionName(extensionNames);

        //简介
        archive.setIntroduction(vn.getDescription());

        // 限制级
        //archive.setRestricted();

        // 相关网站
        //archive.setWebsite();

        // 角色
        VndbResponse<Character> character_tcp = VndbGetMethod.GetCharacter(VndbFilters.VisualNovel.Equals(17).toString());
        List<GameArchive.Characters> characters = character_tcp.getItems().stream().map(x -> {
            return new GameArchive().new Characters(
                    x.getId(),
                    x.getVoiced().stream().filter(v -> v.getVid() == 17)
                            .findFirst().map(VoiceActorMetadata::getId).orElse(0),
                    x.getVns().stream().filter(p -> (Integer) p[0] == 17).findFirst().map(m -> (String) m[3]).get().equals("main") ? 1 : 0
            );
        }).collect(Collectors.toList());
        archive.setCharacters(characters);

        // 发售信息， TODO 可能发售了多个平台  国家没有只有语言  LocalDate格式化的问题
        VndbResponse<com.ymgal.model.Release.Release> release_tcp = VndbGetMethod.GetRelease(VndbFilters.VisualNovel.Equals(17).toString());
        List<GameArchive.Release> releases = release_tcp.getItems().stream().map(x -> {
            return new GameArchive().new Release(x.getTitle(), x.getWebsite(),
                    x.getPlatforms().stream().collect(Collectors.joining(",")),
                    //LocalDate.parse(x.getReleased()),
                    LocalDate.now(),
                    x.getLanguages().stream().collect(Collectors.joining(",")),
                    String.valueOf(x.getMinage()));
        }).collect(Collectors.toList());
        archive.setReleases(releases);

        //Staff
        VndbResponse<VisualNovel> visualNovelVndbResponse = VndbGetMethod.GetVisualNovel(VndbFilters.Id.Equals(17).toString());
        VisualNovel vn_tcp = visualNovelVndbResponse.getItems().get(0);
        List<GameArchive.Staff> staff = vn_tcp.getStaff().stream().map(x -> {
            return new GameArchive().new Staff(x.getSid(), x.getName(), x.getNote(), x.getRole());
        }).collect(Collectors.toList());
        archive.setStaff(staff);

        System.out.println("GameArchive：  " + JsonHelper.serialize(archive));
        return archive;
    }


    @Test
    public OrgArchive getOrgArchive() {

        OrgArchive orgArchive = new OrgArchive();

        VndbResponse<Producer> ProducerVndbResponse = VndbGetMethod.GetProducer(VndbFilters.Id.Equals(9).toString());
        Producer producer = ProducerVndbResponse.getItems().get(0);

        orgArchive.setVndbPid(9);
        orgArchive.setOrgName(producer.getName());
        orgArchive.setCountry(producer.getLanguage());

        // TODO 没有图片
        orgArchive.setMainImg("http://fff");

        // TODO 没有创立时间
        orgArchive.setBirthday(LocalDate.now());

        orgArchive.setIntroduction(producer.getDescription());

        // 网站
        if (producer.getLinks() != null) {
            orgArchive.setWebsite(new ArrayList<Website>() {
                {
                    this.add(new Website(producer.getLinks().getWikidata(),
                            producer.getLinks().getHomepage()));
                }
            });
        }

        // TODO 只有别名
        if (producer.getAliases() != null) {
            orgArchive.setExtensionNames(producer.getAliases().stream().map(item -> new ExtensionName(item))
                    .collect(Collectors.toList()));
        }
        System.out.println("orgArchive：  " + JsonHelper.serialize(orgArchive));

        return orgArchive;
    }

    @Test
    public List<PersonArchive> getPersonArchiveList() {
        VndbResponse<Staff> StaffVndbResponse = VndbGetMethod.GetStaff(VndbFilters.Id.Equals(2).toString());
        List<Staff> staffList = StaffVndbResponse.getItems();
        List<PersonArchive> personArchiveList = staffList.stream().map(x -> {
            return new PersonArchive(
                    x.getId(),
                    x.getName(),
                    x.getAliases().stream().map(a -> {
                        return new ExtensionName((String) a[2]);
                    }).collect(Collectors.toList()),
                    x.getDescription(),
                    x.getLanguage(),
                    // TODO 没有生日
                    LocalDate.now(),
                    new ArrayList<Website>() {{
                        this.add(new Website(x.getLinks().getWikipedia(), x.getLinks().getHomepage()));
                    }},
                    // TODO 没有图片
                    "http://fff",
                    x.getGender().equals("m") ? 1 : 0
            );
        }).collect(Collectors.toList());

        System.out.println("personArchiveList：  " + JsonHelper.serialize(personArchiveList));
        return personArchiveList;
    }

    @Test
    public List<CharacterArchive> getCharacterArchiveList() {
        VndbResponse<Character> CharacterVndbResponse = VndbGetMethod.GetCharacter(VndbFilters.VisualNovel.Equals(17).toString());
        List<Character> characterList = CharacterVndbResponse.getItems();
        List<CharacterArchive> characterArchives = characterList.stream().map(x -> {
            return new CharacterArchive(
                    x.getId(),
                    x.getName(),
                    new ArrayList<ExtensionName>() {{
                        this.add(new ExtensionName(x.getAliases()));
                    }},
                    x.getDescription(),
                    // TODO 生日格式不对，[17,12]
                    LocalDate.now(),
                    x.getImage(),
                    x.getGender().equals("m") ? 1 : 0
            );
        }).collect(Collectors.toList());

        System.out.println("characterArchives：  " + JsonHelper.serialize(characterArchives));

        return characterArchives;
    }


    @Test
    public void getHarvestResult() {
        TcpHelper.Login();
        HarvestResult harvestResult = HarvestResult.ok(
                getGameAcrhive(), getOrgArchive(), getPersonArchiveList(), getCharacterArchiveList()
        );
        TcpHelper.Loginout();

        System.out.println("characterArchives：  " + JsonHelper.serialize(harvestResult));
        //return harvestResult;
    }

}
