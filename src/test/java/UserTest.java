
import mybatis.simple.mapper.SysUserMapper;
import mybatis.simple.model.Country;
import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest extends BaseMapperTest {


    @Test
    public void testdeleteUser(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUser user =userMapper.selectById(1);
            // 现在还能查询出 user 对象
            Assert.assertNotNull(user) ;
            userMapper.delUserById(user);
            // 再次查询就 这里就为null了
            Assert.assertNotNull(userMapper.selectById(1)) ;

        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.rollback();//回滚
            //sqlSession.commit();//提交
            sqlSession.close();
        }
    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUser user =userMapper.selectById(1);
            //当前 userName 为 admin
            Assert.assertEquals("admin",user.getUserName());
            user.setUserName("admin_test");
            userMapper.updateUser(user);
            Assert.assertEquals("admin_test",user.getUserName());
            //printSysUserList(countryList);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.rollback();//回滚
            //sqlSession.commit();//提交
            sqlSession.close();
        }
        }
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
    @Test
    public void testSelectByIds(){
        SqlSession sqlSession = this.getSqlSession();
        try {

            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
           // SysUser sysUser = userMapper.selectById(1);
            List<Long> ids=new ArrayList<>();
            ids.add(1L);
            ids.add(1001L);
            List<SysUser> sysRole = userMapper.selectByIds(ids);
            //printSysUserList(sysUser);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void selectUserAndRoleById(){
        SqlSession sqlSession = this.getSqlSession();
        try {

            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = userMapper.selectUserAndRoleById(1L);
            System.out.println(sysUsers);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }

    @Test
    public void selectUserAndRoles(){
        SqlSession sqlSession = this.getSqlSession();
        try {

            SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = userMapper.selectAllUserAndRoles();
            System.out.println(sysUsers);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }




}
