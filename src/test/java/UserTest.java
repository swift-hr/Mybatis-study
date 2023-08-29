
import mybatis.simple.mapper.SysUserMapper;
import mybatis.simple.model.Country;
import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest extends BaseMapperTest {


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            List<SysUser> countryList = sqlSession.selectList("selectUserAll");
            //printSysUserList(countryList);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = this.getSqlSession();
        try {

            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
           // SysUser sysUser = userMapper.selectById(1);
            List<SysRole> sysRole = userMapper.selectRolesByUserid(1);
            //printSysUserList(sysUser);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }



    private void printSysUserList(SysUser user) {
           // System.out.println("%-4d%4s%4s\n",country.getId(),country.getCountryCode(),country.getCountryName());
            System.out.println(user.toString());

    }

}
