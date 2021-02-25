package top.plgxs.admin.controller.sys;

import javax.annotation.Resource;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysDictTypeService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysDictType;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 字典类型 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
@Controller
@RequestMapping("/sysDictType")
public class SysDictTypeController {
    @Resource
    private SysDictTypeService sysDictTypeService;

    /**
     * 字典类型页面
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/list")
    public String list(){
        return "sys/dictType/list";
    }

    /**
     * 分页查询列表
     * @param name 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("dict_type_name", name).or().like("dict_type_code",name);
        }
        queryWrapper.orderByDesc("gmt_create");
        Page<SysDictType> page = new Page<>(pageNo, pageSize);
        IPage<SysDictType> pageList = sysDictTypeService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysDictType>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/add")
    public String add(){
        return "sys/dictType/add";
    }

    /**
     * 插入一条数据
     * @param sysDictType
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-23
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysDictType sysDictType){
        sysDictType.setGmtCreate(LocalDateTime.now());
        boolean result = sysDictTypeService.save(sysDictType);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysDictType sysDictType = sysDictTypeService.getById(id);
        model.addAttribute("sysDictType",sysDictType);
        return "sys/dictType/edit";
    }

    /**
     * 更新一条数据
     * @param sysDictType
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-23
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysDictType sysDictType){
        if(sysDictType == null || StringUtils.isBlank(sysDictType.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = sysDictTypeService.updateById(sysDictType);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-23
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysDictTypeService.removeById(id);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     * @param ids id数组
     * @author Stranger。
     * @since 2021-02-23
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysDictTypeService.removeByIds(ids);
        if(result){
            return ResultInfo.success("删除成功",null);
        }else{
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     * @param id 主键
     * @param status 状态
     * @author Stranger。
     * @since 2021-02-23
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        SysDictType sysDictType = new SysDictType();
        sysDictType.setId(id);
        sysDictType.setStatus(status);
        boolean result = sysDictTypeService.updateById(sysDictType);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }

    /**
     * 验证字典类型编码是否唯一
     * @param code 编码
     * @author Stranger。
     * @since 2021/2/25 0025
     */
    @GetMapping("/verifyCode")
    @PostMapping
    public ResultInfo<String> verifyCode(@RequestParam("code") String code) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type_code", code);
        List<SysDictType> list = sysDictTypeService.list(queryWrapper);
        if (list != null && list.size() > 0) {
            return ResultInfo.success();
        }
        return ResultInfo.failed();
    }
}
