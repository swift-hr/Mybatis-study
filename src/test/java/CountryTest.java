import mybatis.simple.model.Country;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryTest {

    private static SqlSessionFactory sqlSessionFactory;



    @BeforeClass
    public static void init () {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml") ;
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Country> countryList = sqlSession.selectList("selectAll");
            //List<SysUser> countryList = sqlSession.selectList("selectUserAll");
            //printCountryList(countryList);
            //printSysUserList(countryList);
        } finally {
        //不要忘记关闭 sqlSession
            sqlSession.close();
        }
        }


    private void printCountryList(List<Country> countryList) {
        for(Country country : countryList) {
           // System.out.println("%-4d%4s%4s\n",country.getId(),country.getCountryCode(),country.getCountryName());
            System.out.println(country.toString());
        }
    }

    private void printSysUserList(List<SysUser> countryList) {
        for(SysUser country : countryList) {
           // System.out.println("%-4d%4s%4s\n",country.getId(),country.getCountryCode(),country.getCountryName());
            System.out.println(country.toString());
        }
    }


        public static void main(String[] args) {

}
}
