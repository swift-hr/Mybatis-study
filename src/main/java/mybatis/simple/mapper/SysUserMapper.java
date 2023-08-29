package mybatis.simple.mapper;


import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyj
 * @since 2023-01-09 11:12:11
 */
public interface SysUserMapper {

    /**
     *查询所有用户
     * @return
     */
    List<SysUser> selectUserAll();
    /**
     *通过 id 查询用户
     *
     * @param id
     * @return
     */
    SysUser selectById(@Param("id") int id);



    List<SysRole> selectRolesByUserid(@Param("id") int id);

}
