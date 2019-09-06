package com.lingyun.sellergoods.service;

import com.lingyun.pojo.TbBrand;
import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentCategory;
import entity.PageResult;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

   /* List<TbContent> findTbContent();*/

    /* *
     *@方法名   addType
     *@描述   新增广告分类
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 19:38
     */
    public void addType(TbContentCategory tbContentCategory);

    /* *
     *@方法名   delType
     *@描述   删除广告分类
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 20:02
     */
    public void delType(Long id);

    /* *
     *@方法名   delTypeIds
     *@描述    批量删除广告分类
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 20:14
     */
    public void delTypeIds(Long[] ids);

    /* *
     *@方法名   updateTypeById
     *@描述   广告分类修改回显
     *@返回值类型  com.lingyun.pojo.TbContentCategory
     *@作者 郭廷俊
     *@时间 2019/9/3 20:08
     */
    public TbContentCategory updateTypeById(Long id);

    /* *
     *@方法名   updateType
     *@描述   广告分类修改
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 20:08
     */
    public void updateType(TbContentCategory tbContentCategory);

    /* *
     *@方法名   findType
     *@描述   广告分类列表 分类查询
     *@返回值类型  entity.PageResult
     *@作者 郭廷俊
     *@时间 2019/9/3 20:32
     */
    public PageResult findType(int pageSize,int pageNum);

    /* *
     *@方法名   findType
     *@描述   广告分类列表 分类查询 条件查询
     *@返回值类型  entity.PageResult
     *@作者 郭廷俊
     *@时间 2019/9/3 20:43
     */
    public PageResult findType(TbContentCategory tbContentCategory,int pageNum,int pageSize);

    /* *
     *@方法名   addContent
     *@描述   新增广告
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 21:48
     */
    public void addContent(TbContent tbContent);

    /* *
     *@方法名   delContentIds
     *@描述   批删广告
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 21:48
     */
    public void delContentIds(Long[] ids);

    /* *
     *@方法名   updateContentById
     *@描述   广告修改回显
     *@返回值类型  com.lingyun.pojo.TbContent
     *@作者 郭廷俊
     *@时间 2019/9/3 21:49
     */
    public TbContent updateContentById(Long id);

    /* *
     *@方法名   updateContent
     *@描述   广告修改
     *@返回值类型  void
     *@作者 郭廷俊
     *@时间 2019/9/3 21:49
     */
    public void updateContent(TbContent tbContent);

    /* *
     *@方法名   findTbContentPage
     *@描述   查询广告列表 分页查询 （俩表）
     *@返回值类型  entity.PageResult
     *@作者 郭廷俊
     *@时间 2019/9/3 21:58
     */
    public PageResult findPage(TbContent tbContent, int pageNum, int pageSize);

    /* *
     *@方法名   findTbContentCategoryAll
     *@描述   广告分类列表查询
     *@返回值类型  java.util.List<com.lingyun.pojo.TbContentCategory>
     *@作者 郭廷俊
     *@时间 2019/9/4 14:17
     */
    public List<TbContentCategory> findTbContentCategoryAll();
}
