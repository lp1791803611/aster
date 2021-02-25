package top.plgxs.admin.controller.sys;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.service.sys.SysDeptService;
import top.plgxs.common.api.ResultInfo;
import top.plgxs.common.constants.Constants;
import top.plgxs.common.api.node.LayuiTreeNode;
import top.plgxs.common.api.page.PageDataInfo;
import top.plgxs.common.util.LayuiTreeUtils;
import top.plgxs.mbg.entity.sys.SysDept;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-08
 */
@Controller
@RequestMapping("/sysDept")
public class SysDeptController {
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 部门页面
     *
     * @author Stranger。
     * @since 2021-02-08
     */
    @GetMapping("/list")
    public String list() {
        return "sys/dept/list";
    }

    /**
     * 分页查询列表
     *
     * @param name     部门名称
     * @param id       部门id
     * @param pageNo   第几页
     * @param pageSize 每页几条
     * @return
     * @author Stranger。
     * @since 2021-02-08
     */
    @GetMapping("/pageList")
    @ResponseBody
    public ResultInfo<PageDataInfo> queryPageList(@RequestParam(name = "name", required = false) String name,
                                                  @RequestParam(name = "id", required = false) String id,
                                                  @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("dept_name", name);
        }
        if (StrUtil.isNotBlank(id)) {
            queryWrapper.eq("parent_id", id);
        }
        queryWrapper.orderByAsc("sort");
        Page<SysDept> page = new Page<>(pageNo, pageSize);
        IPage<SysDept> pageList = sysDeptService.page(page, queryWrapper);
        return ResultInfo.success(new PageDataInfo<SysDept>(pageList.getRecords(), pageList.getTotal()));
    }

    /**
     * 获取部门的tree列表，layuiTree格式
     *
     * @return top.plgxs.common.api.ResultInfo<java.util.List < top.plgxs.common.node.LayuiTreeNode>>
     * @author Stranger。
     * @since 2021/2/10
     */
    @GetMapping("/layuiTree")
    @ResponseBody
    public ResultInfo<List<LayuiTreeNode>> layuiTree() {
        List<LayuiTreeNode> nodes = sysDeptService.layuiTree();
        nodes.add(LayuiTreeUtils.createRoot(true, false));
        List<LayuiTreeNode> list = LayuiTreeUtils.doTreeBuildByRecursion(nodes, Constants.TOP_DEPT_PARENT_ID);
        return ResultInfo.success(list);
    }

    /**
     * 获取部门的tree列表，用于xmselect
     *
     * @return top.plgxs.common.api.ResultInfo<java.util.List < top.plgxs.common.node.LayuiTreeNode>>
     * @author Stranger。
     * @since 2021/2/10
     */
    @GetMapping("/xmselectTree")
    @ResponseBody
    public ResultInfo<List<LayuiTreeNode>> xmselectTree() {
        List<LayuiTreeNode> nodes = sysDeptService.layuiTree();
        nodes.add(LayuiTreeUtils.createRoot(false, true));
        List<LayuiTreeNode> list = LayuiTreeUtils.doTreeBuildByRecursion(nodes, Constants.TOP_DEPT_PARENT_ID);
        return ResultInfo.success(list);
    }

    /**
     * 添加页面
     *
     * @param pid 父部门id
     * @author Stranger。
     * @since 2021-02-08
     */
    @GetMapping("/add")
    public String add(@RequestParam("pid") String pid, Model model) {
        String parentId = "0";
        String parentName = "顶级";
        if (StringUtils.isNotBlank(pid) && !Constants.TOP_DEPT_ID.equals(pid)) {
            parentId = pid;
            SysDept dept = sysDeptService.getById(pid);
            parentName = dept.getDeptName();
        }
        model.addAttribute("parentId", parentId);
        model.addAttribute("parentName", parentName);
        return "sys/dept/add";
    }

    /**
     * 插入一条数据
     *
     * @param sysDept
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-08
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResultInfo<Object> insert(@RequestBody SysDept sysDept) {
        sysDept.setGmtCreate(LocalDateTime.now());
        boolean result = sysDeptService.save(sysDept);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 编辑页面
     *
     * @author Stranger。
     * @since 2021-02-08
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        SysDept sysDept = sysDeptService.getById(id);
        String parentName = "顶级";
        if (!Constants.TOP_DEPT_ID.equals(sysDept.getParentId())) {
            SysDept parentDept = sysDeptService.getById(sysDept.getParentId());
            parentName = parentDept.getDeptName();
        }
        model.addAttribute("sysDept", sysDept);
        model.addAttribute("parentName", parentName);
        return "sys/dept/edit";
    }

    /**
     * 更新一条数据
     *
     * @param sysDept
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-08
     */
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo<Object> update(@RequestBody SysDept sysDept) {
        if (sysDept == null || StringUtils.isBlank(sysDept.getId())) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysDeptService.updateById(sysDept);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 逻辑删除一条数据
     *
     * @param id 主键
     * @return top.plgxs.common.api.ResultInfo<java.lang.Object>
     * @author Stranger。
     * @since 2021-02-08
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return ResultInfo.validateFailed();
        }
        boolean result = sysDeptService.removeById(id);
        if (result) {
            return ResultInfo.success();
        } else {
            return ResultInfo.failed();
        }
    }

    /**
     * 批量删除
     *
     * @param ids id数组
     * @author Stranger。
     * @since 2021-02-08
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public ResultInfo<Object> batchDelete(@RequestBody List<String> ids) {
        boolean result = sysDeptService.removeByIds(ids);
        if (result) {
            return ResultInfo.success("删除成功", null);
        } else {
            return ResultInfo.failed("删除失败");
        }
    }

    /**
     * 切换状态
     *
     * @param id     主键
     * @param status 状态
     * @author Stranger。
     * @since 2021-02-08
     */
    @PostMapping("/switchStatus")
    @ResponseBody
    public ResultInfo<String> switchStatus(@RequestParam(name = "id") String id, @RequestParam(name = "status") String status) {
        SysDept sysDept = new SysDept();
        sysDept.setId(id);
        sysDept.setStatus(status);
        boolean result = sysDeptService.updateById(sysDept);
        if (result) {
            return ResultInfo.success("切换成功", null);
        } else {
            return ResultInfo.failed("切换失败");
        }
    }
}
