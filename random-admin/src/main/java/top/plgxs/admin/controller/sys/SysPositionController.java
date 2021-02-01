package top.plgxs.admin.controller.sys;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysPositionService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.page.PageDataInfo;
import top.plgxs.mbg.entity.sys.SysPosition;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 职位 前端控制器
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-01
 * @version 1.0
 */
@Controller
@RequestMapping("/sysPosition")
public class SysPositionController {
    @Resource
    private SysPositionService sysPositionService;

    /**
     * 职位页面
     * @author Stranger。
     * @since 2021-02-01
     */
    @GetMapping("/list")
    public String list(){
        return "sys/position/list";
    }

    /**
     * 分页查询列表
     * @param searchParams 查询条件
     * @param pageNo 第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-01
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "searchParams", required = false) String searchParams, @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        QueryWrapper<SysPosition> queryWrapper = new QueryWrapper<>();
        //TODO 查询条件
        queryWrapper.orderByDesc("gmt_modified");
        Page<SysPosition> page = new Page<>(pageNo, pageSize);
        IPage<SysPosition> pageList = sysPositionService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysPosition>(pageList.getRecords(),pageList.getTotal()));
    }

    /**
     * 添加页面
     * @author Stranger。
     * @since 2021-02-01
     */
    @GetMapping("/add")
    public String add(){
        return "sys/position/add";
    }

    /**
     * 插入一条数据
     * @param sysPosition
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-01
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysPosition sysPosition){
        sysPosition.setGmtCreate(LocalDateTime.now());
        boolean result = sysPositionService.save(sysPosition);
        if(result){
            return ResultInfo.success();
        }else{
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     * @author Stranger。
     * @since 2021-02-01
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id){
        SysPosition sysPosition = sysPositionService.getById(id);
        model.addAttribute("sysPosition",sysPosition);
        return "sys/position/edit";
    }

    /**
     * 更新一条数据
     * @param sysPosition
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-01
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysPosition sysPosition){
        if(sysPosition == null || StringUtils.isBlank(sysPosition.getId())){
            return ResultInfo.validateFailed();
        }
        boolean result = sysPositionService.updateById(sysPosition);
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
     * @since 2021-02-01
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id){
        if(StringUtils.isBlank(id)){
            return ResultInfo.validateFailed();
        }
        boolean result = sysPositionService.removeById(id);
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
     * @since 2021-02-01
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids){
        boolean result = sysPositionService.removeByIds(ids);
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
     * @since 2021-02-01
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name="id") String id, @RequestParam(name = "status") String status){
        SysPosition sysPosition = new SysPosition();
        sysPosition.setId(id);
        sysPosition.setStatus(status);
        boolean result = sysPositionService.updateById(sysPosition);
        if(result){
            return ResultInfo.success("切换成功",null);
        }else{
            return ResultInfo.failed("切换失败");
        }
    }
}
