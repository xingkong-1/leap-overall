package priv.leap.dao.background.administrator;

import priv.leap.entity.background.administrator.AdminstratorInfoEntity;

import java.util.List;

public interface AdministratorDao {
    List<AdminstratorInfoEntity> getAll();
}
