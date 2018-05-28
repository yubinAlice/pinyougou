package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Date:2018/5/24
 * Desc:
 */
public interface BrandMapper extends Mapper<TbBrand> {

    //查询所有品牌的接口
    List<TbBrand> queryAll();
}
