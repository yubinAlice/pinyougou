package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Date:2018/5/25
 * Desc:
 */
@RequestMapping("/brand")
@RestController
public class BrandController {

    @Reference
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<TbBrand> findAll(){

        return brandService.findAll();

    }

    @GetMapping("/testPage")
    public List<TbBrand> testPage(Integer page,Integer rows){

        return (List<TbBrand>)brandService.findPage(page,rows).getRows();

    }

    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="rows",defaultValue="10")Integer rows){
        return brandService.findPage(page,rows);

    }

    @PostMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return Result.ok("新增成功");
        } catch (Exception e) {
            return Result.fail("新增失败");
        }
    }

    @GetMapping("/findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);

    }

    @PostMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return Result.ok("新增成功");
        } catch (Exception e) {
            return Result.fail("新增失败");
        }
    }

    @GetMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.deleteByIds(ids);
            return Result.ok(" 删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.fail(" 删除失败");
    }

    @PostMapping("/search")
    public PageResult update(@RequestBody TbBrand brand,@RequestParam(value="page",defaultValue="1")Integer page, @RequestParam(value="rows",defaultValue="10")Integer rows ){
        return brandService.search(brand,page,rows);
    }


}
