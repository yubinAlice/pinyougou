package com.pinyougou.sellergoods.service;

import com.pinyoougou.service.BaseService;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.PageResult;

import java.util.List;

/**
 * Date:2018/5/25
 * Desc:
 */
public interface BrandService extends BaseService<TbBrand> {
    public List<TbBrand> queryAll();

    List<TbBrand> testPage(Integer page, Integer rows);

    PageResult search(TbBrand brand,Integer page,Integer rows);
}
