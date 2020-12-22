package top.plgxs.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.sys.SysUserMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class RandomAdminApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	private SysUserMapper sysUserMapper;

	@Test
	public void testUserPage(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		IPage<SysUser> page = new Page<>(1,5);
		IPage<SysUser> iPage = sysUserMapper.selectPage(page,queryWrapper);
		System.out.println("总页数"+iPage.getPages());
		System.out.println("总记录数"+iPage.getTotal());
		List<SysUser> list = iPage.getRecords();
		list.forEach(System.out::println);
	}

	@Test
	public void selectById(){
		SysUser user = sysUserMapper.selectById("153B42-1095");
		System.out.println(user);
	}

	@Test
	public void testWrapper(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈").eq("gender","1");
		List<SysUser> list = sysUserMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	// username like '陈%' and (gender='1' or mobile is not null)
	@Test
	public void testWrapper1(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈")
			.and(qw->qw.eq("gender","1").or().isNotNull("mobile"));
		List<SysUser> list = sysUserMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	// username like '陈%' or (gender='1' and mobile is not null)
	@Test
	public void testWrapper2(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.likeRight("username","陈")
				.or(qw->qw.eq("gender","1").isNotNull("mobile"));
		List<SysUser> list = sysUserMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}

	// (gender='1' or mobile is not null) and username like '陈%'
	@Test
	public void testWrapper3(){
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.nested(qw->qw.eq("gender","1").or().isNotNull("mobile"))
				.likeRight("username","陈");
		List<SysUser> list = sysUserMapper.selectList(queryWrapper);
		list.forEach(System.out::println);
	}
}
