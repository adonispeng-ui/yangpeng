package com.example.yangpeng.service.Impl;

import com.example.yangpeng.entity.ColuimnEntity;
import com.example.yangpeng.mapper.ColuimnEntityMapper;
import com.example.yangpeng.service.ColuimnService;
import com.example.yangpeng.utils.Page;
import com.example.yangpeng.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: yangpeng
 * @description
 * @author: YouName
 * @create: 2020-06-04 15:26
 **/
@Service
public class ColuimnServiceImpl  implements ColuimnService {


    @Autowired
    private ColuimnEntityMapper coluimnEntityMapper;

    @Override
    public Integer insertColuimn(ColuimnEntity coluimnEntity) {
        coluimnEntity.setIdColuimn(UUIDUtils.getUUID32());
        coluimnEntity.setStatusColumn(0);
        return coluimnEntityMapper.insertSelective(coluimnEntity);
    }

    @Override
    public ColuimnEntity getColuimnById(String coluimnId) {
        return coluimnEntityMapper.selectByPrimaryKey(coluimnId);
    }

    @Override
    public Integer examineByColuimnId(String idColuimn,Integer statusColumn) {
        return coluimnEntityMapper.examineByColuimnId(idColuimn,statusColumn);
    }

    @Override
    public Page<Map<String, Object>>  listColuimnById(String parentLevelColumn, Integer pageSize, Integer pageNumber,int statusColumn) {
        // 先创建一个page 对象 然后把pageSize 和pageNumber 传给page
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(pageSize != null ? pageSize : 0);
        // 创建成员变量 endNum 结束分页
        Integer endNum = null;
        // 创建成员变量 startNum 开始分页
        Integer startNum = null;
        // 判断 pageSize 每页显示多少个
        // pageNumber 显示第几页
        // 如果 连个参数不都为空 哪么
        if (pageSize != null && pageNumber != null) {
            // 那么页数从第一页开始
            page.setPageNo(pageNumber);
            // 所有的参数 是 每页显示多少行 * 多少页
            endNum = pageSize * pageNumber;
            // 开始是 所有参数 减去 每页显示多少行
            startNum = endNum - pageSize;
        }
        // 创建一个参数的 map 里面放入 开始页和结束页 和用户名字
        Map<String, Object> params = new HashMap<String, Object>();
        // 传给下一层 给后端传参数

        params.put("startNum", startNum);
        params.put("endNum", pageSize);
        params.put("parentLevelColumn", parentLevelColumn);
        params.put("statusColumn",statusColumn);

        List<Map<String, Object>> list  = coluimnEntityMapper.listColuimnById(params);
        // 通过用户名查询所有条数
        Integer  totalCount = coluimnEntityMapper.countColuimnById(params);

        // 把 查到的 数据传给 page
        page.setResult(list);
        page.setTotalCount(totalCount);
        return page  ;
    }


}
