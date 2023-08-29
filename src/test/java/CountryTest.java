
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

public class CountryTest extends BaseMapperTest {


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            //List<Country> countryList = sqlSession.selectList("selectAll");
            List<SysUser> countryList = sqlSession.selectList("selectUserAll");
            //printCountryList(countryList);
            printSysUserList(countryList);
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

}
