package mybatis.simple.mapper;


import mybatis.simple.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyj
 * @since 2023-01-09 11:12:11
 */
public interface SysPrivilegeMapper {

    List<SysPrivilege> selectPrivilegeAll();

    @SelectProvider(type =PrivilegeProvider.class, method = "selectPrivilegeById")
    SysPrivilege selectPrivilegeById(Long id);


}
