package com.example.yangpeng.service.Impl;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.mapper.UserEntityMapper;
import com.example.yangpeng.service.UserService;
import com.example.yangpeng.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;


    @Override
    public Page<Map<String, Object>> getUserList(Integer pageSize, Integer pageNumber) {

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

        // 这是总条数为0
        Integer totalCount = 0;
        // 通过用户名查询所有条数 (不带条件)
        totalCount = userEntityMapper.getUserListCount();
        // 把查询出来的给参数穿进去
        // 查询所有参数
        List<Map<String, Object>> list = userEntityMapper.getUserList(params);
        // 把 查到的 数据传给 page
        page.setResult(list);
        page.setTotalCount(totalCount);
        return page;
    }

    /**
     * 创建用户
     *
     * @param userEntity
     * @return
     */
    @Override
    public Integer insertUser(UserEntity userEntity) {
        userEntity.setIdUser(this.getUUID32());
        System.out.println(userEntity.getIdUser());
        int state = userEntityMapper.insertSelective(userEntity);

        return state;
    }

    /**
     * 取用户名
     *
     * @param accountUser
     * @return
     */
    @Override
    public boolean getUserByAccount(String accountUser) {
        //取库里用户名
        String userId = userEntityMapper.getUserByAccount(accountUser);

        if (userId == null) {//没有用户
            return true;
        } else {//返回路径
            return false;
        }
    }

    //生成uuid
    public static String getUUID32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}