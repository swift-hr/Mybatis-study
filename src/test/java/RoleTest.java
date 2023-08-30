
import mybatis.simple.mapper.SysRoleMapper;
import mybatis.simple.mapper.SysUserMapper;
import mybatis.simple.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

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
            //printSysUserList(sysUser);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }



}
