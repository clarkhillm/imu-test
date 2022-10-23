package org.gavincui.imutest.dao.dev.pair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevPairDao extends JpaRepository<DevPair, String> {

}
