package com.ymgal.model.vo;

import com.ymgal.model.vo.common.Image;
import com.ymgal.model.vo.common.Trait;
import com.ymgal.model.vo.common.Vns;
import com.ymgal.model.vo.common.VoBase;

import java.util.List;

/**
 * @Auther: lyl
 * @Date: 2023/10/16 10:55
 * @Description:
 */
public class Character extends VoBase {

    public String name;
    public String original;
    public List<String> aliases;
    
    public String description;
    public String blood_type;
    public String height;
    public String weight;
    public String bust;
    public String waist;
    public String hips;
    public String cup;
    public Integer age;
    public String birthday;
    public List<String> sex;
    public Image image;
    public List<Vns> vns;
    public List<Trait> traits;

}
