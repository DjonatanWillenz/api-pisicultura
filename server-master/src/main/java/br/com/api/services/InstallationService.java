package br.com.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.InstallationDao;
import br.com.api.dtos.InstallationDto;
import br.com.api.dtos.InstallationSettingsDto;
import br.com.api.enums.SettingsEnum;
import br.com.api.enums.TaskEnum;
import br.com.api.models.Installation;
import br.com.api.utils.UtilsDate;

@Service
public class InstallationService {

        @Autowired
        private InstallationDao installationDao;

        @Autowired
        private InstallationSettingsService settingsService;

        @Transactional
        public Installation save(InstallationDto installationDto) throws Exception {
                Installation installation = new Installation();
                installation.setDateCreate(UtilsDate.getInstance().getDateCurrent());
                installation.setDescription(installationDto.getDescription());
                installation.setName(installationDto.getName());
                installation = installationDao.saveAndFlush(installation);
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.ACTIVE_SERVICE_TASK_PH.getDescription())
                                                .value("false")
                                                .build());
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.ACTIVE_SERVICE_TASK_TEMPERATURE.getDescription())
                                                .value("false")
                                                .build());
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.ACTIVE_SERVICE_TASK_FOOD.getDescription())
                                                .value("false")
                                                .build());
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.INTERVAL_UPDATE_TASK_PH.getDescription())
                                                .value("15")
                                                .build());
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.INTERVAL_UPDATE_TASK_TEMPERATURE.getDescription())
                                                .value("15")
                                                .build());
                settingsService.save(installation.getId(),
                                InstallationSettingsDto.builder()
                                                .key(SettingsEnum.INTERVAL_UPDATE_TASK_FOOD.getDescription())
                                                .value("15")
                                                .build());
                return installation;
        }

        public Installation findById(Long id) throws Exception {
                return installationDao.findById(id)
                                .orElseThrow(() -> new Exception("Installation not found!"));
        }

        public List<Installation> findInstallationActive() {
                return installationDao.findAll((root, query, cb) -> cb.and(cb.equal(root.get("active"), true)));
        }

        public List<Installation> findInstallationsAndTaskActive(TaskEnum task) {
                return installationDao.findByServiceAndActive(task.ordinal());
        }

}
