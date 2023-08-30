
import mybatis.simple.mapper.SysRoleMapper;
import mybatis.simple.mapper.SysUserMapper;
import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class RoleTest extends BaseMapperTest {




    @Test
    public void testSelectById(){
        SqlSession sqlSession = this.getSqlSession();
        try {

//            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            SysRoleMapper roleMapper=sqlSession.getMapper(SysRoleMapper.class);

           // SysUser sysUser = userMapper.selectById(1);
            List<SysRole> sysRole = roleMapper.selectRole(1L);
            System.out.println(sysRole);
            //printSysUserList(sysUser);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }


    @Test
    public void testInsertRole(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysRoleMapper roleMapper=sqlSession.getMapper(SysRoleMapper.class);
            SysRole role =new SysRole();
            //user.setId(1002L);
           role.setEnabled("1");
           role.setCreateBy("管理员");
           role.setRoleName("测试");
           role.setCreateTime(new Date());
            roleMapper.insertRole(role);
            //userMapper.insertUser(user);
            Assert.assertNotNull(role.getId());
            //printSysUserList(countryList);
        } finally {
            //不要忘记关闭 sqlSession
            //sqlSession.rollback();//回滚
            sqlSession.commit();//提交
            sqlSession.close();
        }
    }


}
