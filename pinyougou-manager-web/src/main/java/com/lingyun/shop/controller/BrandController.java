package com.lingyun.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.pojo.TbBrand;
import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentCategory;
import com.lingyun.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @类名: BrandController
 * @描述:
 * @作者: 郭廷俊
 * @时间: 2019-09-03 16:37
 **/

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(timeout = 60000)
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

  /*  @RequestMapping("/findTbContent")
    public List<TbContent> findTbContent(){
        return brandService.findTbContent();
    }*/

  /* *
   *@方法名   addType
   *@描述   新增广告分类
   *@返回值类型  void
   *@作者 郭廷俊
   *@时间 2019/9/3 21:17
   */
    @RequestMapping("/addType")
     public Result addType(TbContentCategory tbContentCategory){
        if (tbContentCategory.getId() != null ){
            try {
                brandService.updateType(tbContentCategory);
                return new Result(true,"修改成功！！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,"修改失败！！");
            }
        }else {
            try {
                brandService.addType(tbContentCategory);
                return new Result(true,"新增成功！！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,"新增失败！！");
            }
        }

    }

    /* *
     *@方法名   delType
     *@描述   删除广告分类
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:28
     */
    @RequestMapping("delType")
    public Result delType(Long id){
        try {
            brandService.delType(id);
            return new Result(true,"删除成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！！");
        }
    }

    /* *
     *@方法名   delTypeIds
     *@描述   批量删除广告分类
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:30
     */
    @RequestMapping("delTypeIds")
    public Result delTypeIds(Long[] ids){
        try {
            brandService.delTypeIds(ids);
            return new Result(true,"删除成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！！");
        }
    }

    /* *
     *@方法名   updateTypeById
     *@描述   修改回显广告分类
     *@返回值类型  com.lingyun.pojo.TbContentCategory
     *@作者 郭廷俊
     *@时间 2019/9/3 21:34
     */
    @RequestMapping("updateTypeById")
    public TbContentCategory updateTypeById(Long id){
        return brandService.updateTypeById(id);
    }

    /* *
     *@方法名   updateType
     *@描述   修改广告分类
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:35
     */
    @RequestMapping("/updateType")
    public Result updateType(TbContentCategory tbContentCategory){
        try {
            brandService.updateType(tbContentCategory);
            return new Result(true,"修改成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败！！");
        }
    }

    /* *
     *@方法名   findType
     *@描述   广告分类 条查分页
     *@返回值类型  entity.PageResult
     *@作者 郭廷俊
     *@时间 2019/9/3 21:40
     */
    @RequestMapping("/findType")
    public PageResult findType(TbContentCategory tbContentCategory, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows){
        return brandService.findType(tbContentCategory,page,rows);
    }

    /* *
     *@方法名   addContent
     *@描述   新增广告
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:52
     */
    @RequestMapping("/addContent")
    public Result addContent(TbContent tbContent){
        if (tbContent.getId() != null ){
            try {
                brandService.updateContent(tbContent);
                return new Result(true,"修改成功！！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false,"修改失败！！");
            }
        }else {
            try {
            brandService.addContent(tbContent);
            return new Result(true,"新增成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败！！");
        }
        }
    }

    /* *
     *@方法名   delContentIds
     *@描述   广告批删
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:52
     */
    @RequestMapping("delContentIds")
    public Result delContentIds(Long[] ids){
        try {
            brandService.delContentIds(ids);
            return new Result(true,"删除成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！！");
        }
    }

    /* *
     *@方法名   updateContentById
     *@描述   广告修改回显
     *@返回值类型  com.lingyun.pojo.TbContent
     *@作者 郭廷俊
     *@时间 2019/9/3 21:53
     */
    @RequestMapping("updateContentById")
    public TbContent updateContentById(Long id){
        return brandService.updateContentById(id);
    }

    /* *
     *@方法名   updateContent
     *@描述   修改广告
     *@返回值类型  entity.Result
     *@作者 郭廷俊
     *@时间 2019/9/3 21:53
     */
    @RequestMapping("/updateContent")
    public Result updateContent(TbContent tbContent){
        try {
            brandService.updateContent(tbContent);
            return new Result(true,"修改成功！！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败！！");
        }
    }

    /* *
     *@方法名   findType
     *@描述   查询广告列表 分页查询 （俩表）
     *@返回值类型  entity.PageResult
     *@作者 郭廷俊
     *@时间 2019/9/3 22:01
     */
    @RequestMapping("/search")
    public PageResult search(TbContent tbContent,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows) {
        return brandService.findPage(tbContent, page, rows);
    }

    @RequestMapping("/findTbContentCategoryAll")
    public List<TbContentCategory> findTbContentCategoryAll(){
        return brandService.findTbContentCategoryAll();
    }
}
