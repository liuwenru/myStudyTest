package org.ijarvis.EpointTest.SpringMVC.Mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ijarvis.EpointTest.SpringMVC.Model.FrameUser;

import java.util.List;

/**
 * Created by ijarvis on 12/4/16.
 */
public interface FrameuserMapper {
    @Select("select * from frame_user where LOGINID like #{id}")
    public List<FrameUser> selectFrameuser(@Param("id") String id);


}
