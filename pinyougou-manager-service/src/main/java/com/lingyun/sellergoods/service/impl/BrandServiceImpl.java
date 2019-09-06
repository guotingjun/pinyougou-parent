package com.lingyun.sellergoods.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.mapper.TbBrandMapper;
import com.lingyun.mapper.TbContentCategoryMapper;
import com.lingyun.mapper.TbContentMapper;
import com.lingyun.pojo.*;
import com.lingyun.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名: BrandServiceImpl
 * @描述:
 * @作者: 郭廷俊
 * @时间: 2019-09-03 16:30
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public void addType(TbContentCategory tbContentCategory) {
        tbContentCategoryMapper.insert(tbContentCategory);
    }

    @Override
    public void delType(Long id) {
        tbContentCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delTypeIds(Long[] ids) {
        for (Long id:ids) {
            tbContentCategoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbContentCategory updateTypeById(Long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateType(TbContentCategory tbContentCategory) {
        tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
    }

    @Override
    public PageResult findType(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbContentCategory> page = (Page<TbContentCategory>)tbContentCategoryMapper.selectByExample(null);
        long totalPage = (int)Math.ceil(page.getTotal()/pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize,totalPage);
    }

    @Override
    public PageResult findType(TbContentCategory tbContentCategory, int pageNum,int pageSize ) {
        PageHelper.startPage(pageNum,pageSize);
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        if (tbContentCategory != null){
            if (tbContentCategory.getName() != null && tbContentCategory.getName().length()>0){
                criteria.andNameLike( "%" + tbContentCategory.getName() + "%" );
            }
        }
        Page<TbContentCategory> page = (Page<TbContentCategory>)tbContentCategoryMapper.selectByExample(example);
        long totalPage = (int)Math.ceil(page.getTotal()/pageSize) + 1;
        return new PageResult(page.getTotal(),page.getResult(),pageNum,pageSize,totalPage);
    }

    @Override
    public void addContent(TbContent tbContent) {
        tbContentMapper.insert(tbContent);
    }

    @Override
    public void delContentIds(Long[] ids) {
        for (Long id:ids) {
            tbContentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbContent updateContentById(Long id) {
        return tbContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateContent(TbContent tbContent) {
        tbContentMapper.updateByPrimaryKey(tbContent);
    }


    @Override
    public PageResult findPage(TbContent tbContent, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        if (tbContent != null) {
            if (tbContent.getTitle() != null && tbContent.getTitle().length() > 0) {
                criteria.andTitleLike("%" + tbContent.getTitle() + "%");
            }
        }
        Page<TbContent> page = (Page<TbContent>) tbContentMapper.selectByExample(example);
        long totalPage  = (int) Math.ceil(page.getTotal()/ pageSize) + 1;
        return new PageResult(page.getTotal(), page.getResult(), pageNum, pageSize, totalPage);
    }

    @Override
    public List<TbContentCategory> findTbContentCategoryAll() {
        return tbContentCategoryMapper.selectByExample(null);
    }

}
