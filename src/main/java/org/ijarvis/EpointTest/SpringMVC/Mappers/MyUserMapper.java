package org.ijarvis.EpointTest.SpringMVC.Mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.ijarvis.EpointTest.SpringMVC.Model.MyUser;

/**
 * Created by ijarvis on 12/6/16.
 */
public interface MyUserMapper {
    @Insert("insert into testinfo(name,pass,userid) values(#{name},#{pass},#{userid})")
    int InsertUser(MyUser myUser);

    @Update("update testinfo set name=#{name} , pass=#{pass} where userid=#{userid}")
    int UpdateUser(MyUser myUser);

    @Delete()
}
