package org.gavincui.imutest.dao.dev.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevSettingDao extends JpaRepository<DevSetting, String> {
}