package mybatis.simple.mapper;

public class PrivilegeProvider {

    public String selectPrivilegeById(final Long id){

        return "select * from sys_privilege where id=#{id}";
    }
}
