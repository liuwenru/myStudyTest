package org.ijarvis.EpointTest.SpringMVC.SpringMVC.Mapper;

import org.apache.ibatis.annotations.Select;
import org.ijarvis.EpointTest.SpringMVC.Model.frame_user;

/**
 * Created by ijarvis on 12/4/16.
 */
public interface Frame_userMapper {
    @Select("select * from frame_user where userguid= #{id}")
    public frame_user selectFrameuser(String uuid);


}
