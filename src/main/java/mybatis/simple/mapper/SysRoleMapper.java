package mybatis.simple.mapper;


import mybatis.simple.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyj
 * @since 2023-01-09 11:12:11
 */
public interface SysRoleMapper {

    SysRole selectRoleAll();

    @Select(" select id, role_name roleName , enabled, \n" +
            "create_by createBy, \n" +
            "create_time createTime \n" +
            "from sys_role \n" +
            "where id = #{id}")
    List<SysRole> selectRole(Long id);

}
