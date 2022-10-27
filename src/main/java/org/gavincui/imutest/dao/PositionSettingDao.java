package org.gavincui.imutest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionSettingDao extends JpaRepository<PositionSetting, String> {

    @Query(value = "select o.settings from PositionSetting o where o.positionId = ?1")
    String getSettings(String positionId);

}
