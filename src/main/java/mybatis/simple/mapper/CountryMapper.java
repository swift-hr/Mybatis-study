package mybatis.simple.mapper;


import mybatis.simple.model.Country;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuyj
 * @since 2023-01-09 11:12:11
 */
public interface CountryMapper  {

    List<Country> selectAll();


}
