package br.com.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.daos.InstallationSettingsDao;
import br.com.api.dtos.InstallationSettingsDto;
import br.com.api.models.Installation;
import br.com.api.models.InstallationSettings;

@Service
public class InstallationSettingsService {

    @Autowired
    private InstallationSettingsDao settingDao;

    @Autowired
    private InstallationService installationService;

    @Autowired
    private InstallationSettingsDao installationSettingsDao;

    @Transactional
    public InstallationSettings save(Long idinstallation, InstallationSettingsDto dto) throws Exception {
        Installation installation = installationService.findById(idinstallation);
        InstallationSettings settings = new InstallationSettings();
        settings.setInstallation(installation);
        settings.setKey(dto.getKey());
        settings.setValue(dto.getValue());
        return settingDao.saveAndFlush(settings);
    }

    @Transactional
    public void deleteById(Long id) {
        settingDao.deleteById(id);
    }

    public InstallationSettings findByIdInstallationAndKey(Long idinstallation, String key) {
        Page<InstallationSettings> findAll = installationSettingsDao.findAll((root, query, cb) -> {
            root.fetch("installation");
            Join<?, ?> installation = root.join("installation");
            return cb.and(
                    cb.equal(installation.get("idinstallation"), idinstallation),
                    cb.equal(root.get("key"), key));
        }, Pageable.ofSize(1));
        return findAll.stream().findFirst().isPresent() ? findAll.stream().findFirst().get() : null;
    }

    public List<InstallationSettingsDto> findByIdInstallation(Long id) throws Exception {
        if (id == null)
            throw new Exception("Id não informado!");
        List<InstallationSettingsDto> result = new ArrayList<>();
        List<InstallationSettings> settings = settingDao.findAll((root, query, cb) -> {
            root.fetch("installation");
            Join<?, ?> installation = root.join("installation");
            return cb.equal(installation.get("id"), id);
        });
        settings.stream().forEach(setting -> result.add(InstallationSettingsDto.builder()
                .key(setting.getKey())
                .value(setting.getValue())
                .build()));
        return result;
    }
}
