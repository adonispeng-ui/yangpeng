package com.example.yangpeng.controller;

import com.example.yangpeng.entity.ColuimnEntity;
import com.example.yangpeng.service.ColuimnService;
import com.example.yangpeng.utils.Page;
import com.example.yangpeng.utils.ResultJson;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: yangpeng
 * @description
 * @author: YouName
 * @create: 2020-06-04 15:23
 **/
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("ColuimnInterface")
@Api(tags = "栏目接口")
public class ColuimnController {

    private static final Logger logger = LoggerFactory.getLogger(ColuimnController.class);

    @Autowired
    private ColuimnService coluimnService;

    /**
     * 创建栏目接口，
     * 模块id为uuid,状态为0=false 不显示 1=true 显示
     * 模块等级可以自定义 如果选择子级，需要先选择父级，
     * 模块显示顺序 使用字段排序，desc  display_order_column
     *
     * @return
     */
    @ApiOperation(value = "添加板块", notes = "添加板块信息")
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })
    @PostMapping(value = "/insertColuimn")
    @ResponseBody
    public ResultJson insertColuimn(@RequestBody ColuimnEntity coluimnEntity) {
        ResultJson json = new ResultJson();
        if (coluimnEntity.getNameColumn() == null) {
            json.setSuccess(false);
            json.setMsg("栏目名不能为空");
            json.setCode(401);
            return json;
        }
        if (coluimnEntity.getBannerColumn() == null) {
            json.setSuccess(false);
            json.setMsg("栏目图不能为空");
            json.setCode(401);
            return json;
        }
        if (coluimnEntity.getDisplayOrderColumn() == null) {
            json.setSuccess(false);
            json.setMsg("图片显示顺序不能为空");
            json.setCode(401);
            return json;
        }
        if (coluimnEntity.getDescribeColumn() == null) {
            json.setSuccess(false);
            json.setMsg("栏目描述不能为空");
            json.setCode(401);
            return json;
        }
        try {
            Integer coluimnstate = coluimnService.insertColuimn(coluimnEntity);
            if (coluimnstate == 1) {
                json.setObj(coluimnstate);
                json.setSuccess(true);
                json.setCode(200);
                json.setMsg("新增栏目成功");
            } else {
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg("新增栏目失败");
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

    @ApiOperation(value = "查询栏目信息", notes = "查询栏目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "coluimnId", value = "栏目id", dataType = "int", paramType = "query", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })
    /**
     *
     */
    @GetMapping(value = "/getColuimnById")
    @ResponseBody
    public ResultJson getColuimnById(@RequestParam(value = "coluimnId") String coluimnId) {
        ResultJson json = new ResultJson();
        if (coluimnId.equals("")) {
            json.setSuccess(false);
            json.setMsg("栏目id不能为空");
            json.setCode(401);
            return json;
        }

        try {
            ColuimnEntity coluimnEntity = coluimnService.getColuimnById(coluimnId);
            json.setObj(coluimnEntity);
            json.setSuccess(true);
            json.setCode(200);
            json.setMsg("查询栏目成功");


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            json.setSuccess(false);
            json.setCode(500);
            json.setMsg("服务异常");
        }

        return json;
    }


    @ApiOperation(value = "审核栏目", notes = "审核栏目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idColuimn", value = "栏目id", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "statusColumn", value = "栏目状态", dataType = "int", paramType = "query", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })

    /**
     * 审核栏目接口
     * 通过查询到栏目id对栏目审核
     * @param coluimnId
     * @return
     */

    @ResponseBody
    @PostMapping(value = "/examineByColuimnId")
    public ResultJson examineByColuimnId(@RequestParam(value = "idColuimn") String idColuimn, @RequestParam(value = "statusColumn") Integer statusColumn) {
        ResultJson json = new ResultJson();
        if (idColuimn.equals("")) {
            json.setSuccess(false);
            json.setMsg("栏目id不能为空");
            json.setCode(401);
            return json;
        }
        if (statusColumn == null) {
            json.setSuccess(false);
            json.setMsg("栏目状态不能为空");
            json.setCode(401);
            return json;
        }
        try {
            Integer Columnstatus = coluimnService.examineByColuimnId(idColuimn, statusColumn);
            if (Columnstatus == 1) {
                json.setSuccess(true);
                json.setCode(200);
                json.setMsg("审核栏目成功");
            } else {
                json.setSuccess(false);
                json.setCode(500);
                json.setMsg("审核栏目失败");
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
    @ApiOperation(value = "通过父id查询列表", notes = "审核列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentLevelColumn", value = "栏目id", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "分页参数（必传）", dataType = "int", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "pageNumber", value = "分页参数（必传）", dataType = "int", paramType = "query", example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 404, message = "找不到请求路径")
    })
    /**
     * 通过父id 查询列表id
     * @param idColuimn
     * @return
     */
    @ResponseBody
    @GetMapping("/listColuimnById")
    public ResultJson listColuimnById(@RequestParam(value = "parentLevelColumn") String parentLevelColumn ,
                                      @RequestParam(value = "pageSize") int pageSize,
                                      @RequestParam(value = "pageNumber") int pageNumber,
                                      @RequestParam(value = "statusColumn" ) int statusColumn
                                      ) {
        ResultJson json = new ResultJson();
        Page<Map<String, Object>> list  = coluimnService.listColuimnById(parentLevelColumn,pageSize,pageNumber,statusColumn);
        json.setObj(list);
        json.setSuccess(true);
        json.setCode(200);
        json.setMsg("查询成功");

        return  json;
    }
}
