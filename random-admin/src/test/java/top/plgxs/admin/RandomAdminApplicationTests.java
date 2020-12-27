package top.plgxs.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.sys.SysUserMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class RandomAdminApplicationTests {
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysUserMapper sysUserMapper;

	// INSERT INTO t_sys_user ( id, username, mobile ) VALUES ( ?, ?, ? )
	@Test
	public void insert(){
		SysUser user = new SysUser();
		user.setUsername("testusername");
		user.setMobile("11111111111");
		boolean save = sysUserService.save(user);
		// int insert = sysUserMapper.insert(user);
		System.out.println(save);
	}

	// UPDATE t_sys_user SET username=? WHERE id=? AND status='0'
	@Test
	public void update(){
		SysUser user = new SysUser();
		user.setId("1342357296612716546");
		user.setUsername("TestUserName");
		boolean b = sysUserService.updateById(user);
		// int i = sysUserMapper.updateById(user);
		System.out.println(b);
	}

	// UPDATE t_sys_user SET status='1' WHERE id=? AND status='0'
	@Test
	public void delete(){
		boolean b = sysUserService.removeById("1342357296612716546");
		// int i = sysUserMapper.deleteById("1342357296612716546");
		System.out.println(b);
	}

	// WHERE id=? AND status='0'
	@Test
	public void selectById(){
		SysUser user = sysUserService.getById("153B42-1095");
		// SysUser sysUser = sysUserMapper.selectById("153B42-1095");
		System.out.println(user);
	}

	//  WHERE id IN ( ? , ? ) AND status='0'
	@Test
	public void selectByIds(){
		List<String> ids = new ArrayList<>();
		ids.add("153B42-1095");
		ids.add("153B42-1098");
		List<SysUser> list = sysUserService.listByIds(ids);
		// List<SysUser> users = sysUserMapper.selectBatchIds(ids);
		list.forEach(System.out::println);
	}

	// username like '陈%' and gender = '1'
	@Test
	public void testWrapper(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈").eq("gender","1");
		List<SysUser> list = sysUserService.list(queryWrapper);
		// List<SysUser> users = sysUserMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	// username like '陈%' and (gender='1' or mobile is not null)
	@Test
	public void testWrapper1(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈")
			.and(qw->qw.eq("gender","1").or().isNotNull("mobile"));
		List<SysUser> list = sysUserService.list(queryWrapper);
		list.forEach(System.out::println);
	}

	// username like '陈%' or (gender='1' and mobile is not null)
	@Test
	public void testWrapper2(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈")
				.or(qw->qw.eq("gender","1").isNotNull("mobile"));
		List<SysUser> list = sysUserService.list(queryWrapper);
		list.forEach(System.out::println);
	}

	// (gender='1' or mobile is not null) and username like '陈%'
	@Test
	public void testWrapper3(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.nested(qw->qw.eq("gender","1").or().isNotNull("mobile"))
				.likeRight("username","陈");
		List<SysUser> list = sysUserService.list(queryWrapper);
		list.forEach(System.out::println);
	}

	// WHERE (username LIKE ?) LIMIT ?
	@Test
	public void testPage(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈");

		IPage<SysUser> page = new Page<>(1,5);
		IPage<SysUser> iPage = sysUserService.page(page,queryWrapper);
		// IPage<SysUser> userIPage = sysUserMapper.selectPage(page, queryWrapper);
		System.out.println("总页数"+iPage.getPages());
		System.out.println("总记录数"+iPage.getTotal());
		List<SysUser> list = iPage.getRecords();
		list.forEach(System.out::println);
	}

	@Test
	public void morePage(){
		QueryWrapper<Map<String,Object>> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈");
		Page<Map<String,Object>> page = new Page<>(1,5);
		IPage<Map<String,Object>> iPage = sysUserMapper.selectUserPage(page,queryWrapper);
		System.out.println("总页数"+iPage.getPages());
		System.out.println("总记录数"+iPage.getTotal());
		List<Map<String,Object>> list = iPage.getRecords();
		list.forEach(System.out::println);
	}

	@Test
	public void morePage1(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈");
		PageHelper.startPage(1, 5);
		List<SysUser> list = sysUserMapper.selectList(queryWrapper);
		PageInfo<SysUser> pageInfo = new PageInfo<>(list);
		System.out.println("pageNum"+pageInfo.getPageNum());
		System.out.println("pageSize"+pageInfo.getPageSize());
		System.out.println("totalCount"+pageInfo.getTotal());
		System.out.println("totalPages"+pageInfo.getPages());
		list.forEach(System.out::println);
	}
}
