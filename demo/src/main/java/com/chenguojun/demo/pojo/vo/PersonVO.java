package com.chenguojun.demo.pojo.vo;

import com.chenguojun.demo.pojo.po.PersonPO;

/**
 * (Person)VO
 *
 * @author chen （具体开发者修改或追加）
 * @since 2019-08-09 15:45:50
 */
public class PersonVO extends PersonPO {
    /**
     * 创建人
     */
    private String createName;
    /**
     * 修改人
     */
    private String modifyName;

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }
}