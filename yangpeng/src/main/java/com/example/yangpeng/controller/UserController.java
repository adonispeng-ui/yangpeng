package com.example.yangpeng.controller;

import com.example.yangpeng.entity.UserEntity;
import com.example.yangpeng.service.UserService;
import com.example.yangpeng.utils.Page;
import com.example.yangpeng.utils.ResultJson;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("interface")
@Api(tags = "接口")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 时间排序
     * 分页
     * 条件查询
     * @param pageSize
     * @param pageNumber
     * @return
     */
    @ApiOperation(value = "查看用户信息", notes = "查看用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageSize",value="分页参数（必传）",dataType="int", paramType = "query",example="1"),
            @ApiImplicitParam(name="pageNumber",value="分页参数（必传）",dataType="int", paramType = "query",example="1")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })
    @GetMapping(value = "/getUserList")
    @ResponseBody

    public ResultJson getUser(@RequestParam Integer pageSize ,@RequestParam Integer pageNumber){
        ResultJson json = new ResultJson();
        if (pageSize==null) {
            json.setSuccess(false);
            json.setMsg("分页参数pageSize不能为空");
            json.setCode(401);
            return  json;
        }
        if (pageNumber==null) {
            json.setSuccess(false);
            json.setMsg("分页参数pageNumber不能为空");
            json.setCode(401);
            return  json;
        }
        try {
            Page<Map<String, Object>> list = userService.getUserList(pageSize, pageNumber);
            json.setObj(list);
            json.setSuccess(true);
            json.setCode(200);
            json.setMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            json.setSuccess(false);
            json.setCode(500);
            json.setMsg("服务异常");
        }
        return json;
    }

    /**
     * 注册用户
     * @param userEntity
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户进行注册")
    @PostMapping(value = "/insertUser")
    @ResponseBody
    public ResultJson insertUser(@Valid @RequestBody UserEntity userEntity ){
        ResultJson json = new ResultJson();

        if (userEntity.getAccountUser()==null) {
            json.setSuccess(false);
            json.setMsg("用户名不能为空");
            json.setCode(401);
            return  json;
        }

        if (userEntity.getEmailUser()==null) {
            json.setSuccess(false);
            json.setMsg("邮箱不能为空");
            json.setCode(401);
            return  json;
        }

        if(userEntity.getPasswordUser()==null){
            json.setSuccess(false);
            json.setMsg("密码不能为空");
            json.setCode(401);
            return  json;
        }

        try {
            //用户名查id
            boolean accountUserState =  userService.getUserByAccount(userEntity.getAccountUser());

            if(accountUserState == true){//没有用户

                Integer state =userService.insertUser(userEntity);

                if(state == 1){ //创建成功
                    json.setSuccess(true);
                    json.setCode(200);
                    json.setMsg("创建成功");
                }else{//创建失败
                    json.setSuccess(false);
                    json.setCode(500);
                    json.setMsg("创建失败");
                }
            }else{//有用户
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg("用户已经存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            json.setSuccess(false);
            json.setCode(500);
            json.setMsg("服务异常");
        }
        return json;
    }















}
