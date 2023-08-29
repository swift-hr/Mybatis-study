
import mybatis.simple.mapper.SysUserMapper;
import mybatis.simple.model.Country;
import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserTest extends BaseMapperTest {


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUser user =new SysUser();
            //user.setId(1002L);
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("admin@mybatis.test");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[] {1,2,3});
            user.setCreateTime(new Date());
            //userMapper.insertUser(user);
            userMapper.insertUser2(user);
            Assert.assertNotNull(user.getId());
            //printSysUserList(countryList);
        } finally {
        //不要忘记关闭 sqlSession
            //sqlSession.rollback();//回滚
            //sqlSession.commit();//提交
            sqlSession.close();
        }
        }
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
