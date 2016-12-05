package org.ijarvis.EpointTest.SpringMVC.SpringMVC.Mapper;

import org.apache.ibatis.annotations.Select;
import org.ijarvis.EpointTest.SpringMVC.Model.frameuser;

/**
 * Created by ijarvis on 12/4/16.
 */
public interface FrameuserMapper {
    @Select("select * from frameuser where userguid= #{uuid}")
    public frameuser selectFrameuser(String uuid);


}
