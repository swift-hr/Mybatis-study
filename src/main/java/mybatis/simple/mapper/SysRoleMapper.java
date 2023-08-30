package mybatis.simple.mapper;


import mybatis.simple.model.SysRole;
import org.apache.ibatis.annotations.*;

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

//    @Select(" select id, role_name roleName , enabled, \n" +
//            "create_by createBy, \n" +
//            "create_time createTime \n" +
//            "from sys_role \n" +
//            "where id = #{id}")
    @Select("select * from sys_role where id = #{id}")
    List<SysRole> selectRole(Long id);


    /**
     * 这是返回主键的一个插入方法
     * before 为 false 时功能等同于xml中order=" AFTER ”
     *
     * */
    @Insert("   insert into sys_role (role_name, enabled, create_by, create_time )\n" +
            "            values(#{roleName} , #{enabled}, #{createBy},#{createTime , jdbcType= TIMESTAMP})")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty ="id",
              resultType = Long.class,
              before = false)
    int insertRole(SysRole sysRole);


    @Update(" update sys_role set role_name=#{roleName} , enable=#{enabled}, create_by=#{createBy}," +
            "create_time=#{createTime , jdbcType= TIMESTAMP})")
    int updateRole(SysRole sysRole);

    @Update("delete from sys_role where id=#{id}")
    int delRoleById(Long id);

}
