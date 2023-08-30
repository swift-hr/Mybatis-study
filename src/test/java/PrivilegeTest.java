
import mybatis.simple.mapper.SysPrivilegeMapper;
import mybatis.simple.mapper.SysRoleMapper;
import mybatis.simple.model.SysPrivilege;
import mybatis.simple.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class PrivilegeTest extends BaseMapperTest {




    @Test
    public void testSelectById(){
        SqlSession sqlSession = this.getSqlSession();
        try {

//            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            SysPrivilegeMapper sysPrivilegeMapper=sqlSession.getMapper(SysPrivilegeMapper.class);

            SysPrivilege sysPrivilege = sysPrivilegeMapper.selectPrivilegeById(1L);

            // SysUser sysUser = userMapper.selectById(1);
            Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
            System.out.println(sysPrivilege);
            //printSysUserList(sysUser);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }




}
