package br.com.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.InstallationDao;
import br.com.api.daos.UserInstallationDao;
import br.com.api.dtos.InstallationDto;
import br.com.api.models.Installation;
import br.com.api.models.UserInstallation;

@Service
public class UserInstallationService {

  @Autowired
  private UserInstallationDao userInstallationDao;

  @Autowired
  private InstallationDao installationDao;

  public List<UserInstallation> findByIdInstallation(Long id) {
    return userInstallationDao.findAll((root, query, cb) -> cb.equal(root.get("idinstallation"), id));
  }

  public List<InstallationDto> findByIdUser(Long iduser) {
    List<InstallationDto> result = new ArrayList<>();

    List<Installation> installations = installationDao.findAll((root, query, cb) -> {
      root.fetch("bond");
      Join<?, ?> bond = root.join("bond");
      Join<?, ?> user = bond.join("user");     
      return cb.equal(user.get("id"), iduser);
    });
    
    installations.stream().forEach(installation -> {
      result.add(InstallationDto.builder()
        .id(installation.getId())
        .name(installation.getName())
        .description(installation.getDescription())
        .dateCreate(installation.getDateCreate())
        .key(installation.getKey())
        .active(installation.getActive())
        .build());
      });

    return result;
  }

}
