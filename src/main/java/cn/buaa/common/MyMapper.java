package cn.buaa.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Bob
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
