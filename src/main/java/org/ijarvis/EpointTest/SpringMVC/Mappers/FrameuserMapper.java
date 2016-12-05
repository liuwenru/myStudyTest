package org.ijarvis.EpointTest.SpringMVC.Mappers;

import org.apache.ibatis.annotations.Select;
import org.ijarvis.EpointTest.SpringMVC.Model.FrameUser;

/**
 * Created by ijarvis on 12/4/16.
 */
public interface FrameuserMapper {
    @Select("select * from frame_user where userguid= #{uuid}")
    public FrameUser selectFrameuser(String uuid);


}
