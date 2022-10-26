package org.gavincui.imutest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DevSettingDao extends JpaRepository<DevSetting, String> {

    @Query(value = "select obj from DevSetting obj where obj.position=?1")
    List<DevSetting> queryByPositionId(String positionId);
}
