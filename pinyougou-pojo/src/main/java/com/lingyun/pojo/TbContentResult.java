package com.lingyun.pojo;

import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentCategory;

import java.io.Serializable;

/**
 * @类名: TbContentResult
 * @描述:
 * @作者: 郭廷俊
 * @时间: 2019-09-03 19:00
 **/
public class TbContentResult implements Serializable {

    private TbContent tbContent;

    private TbContentCategory tbContentCategory;

    public TbContent getTbContent() {
        return tbContent;
    }

    public void setTbContent(TbContent tbContent) {
        this.tbContent = tbContent;
    }

    public TbContentCategory getTbContentCategory() {
        return tbContentCategory;
    }

    public void setTbContentCategory(TbContentCategory tbContentCategory) {
        this.tbContentCategory = tbContentCategory;
    }

    public TbContentResult(TbContent tbContent, TbContentCategory tbContentCategory) {
        this.tbContent = tbContent;
        this.tbContentCategory = tbContentCategory;
    }

    public TbContentResult() {
    }

    @Override
    public String toString() {
        return "TbContentResult{" +
                "tbContent=" + tbContent +
                ", tbContentCategory=" + tbContentCategory +
                '}';
    }
}