package br.com.api.services;

import java.util.List;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.TemperatureDao;
import br.com.api.dtos.TemperatureDto;
import br.com.api.models.Installation;
import br.com.api.models.Temperature;
import br.com.api.utils.UtilsDate;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureDao temDao;

    @Autowired
    private InstallationService installationService;

    @Transactional
    public Temperature save(TemperatureDto dto) throws Exception {
        Installation installation = installationService.findById(dto.getIdinstallation());
        Temperature temp = new Temperature();
        temp.setInstallation(installation);
        temp.setDate(UtilsDate.getInstance().getDateCurrent());
        temp.setRun(dto.getRun());
        temp.setValue(dto.getValue());
        temp.setState(dto.getState());
        return temDao.save(temp);
    }

    public List<Temperature> findByIdInstallation(Long id) {
        return temDao.findAll((root, query, cb) -> {
            root.fetch("installation");
            Join<?, ?> installation = root.join("installation");
            return cb.and(cb.equal(installation.get("id"), id));
        });
    }

    public Temperature findById(Long id) throws Exception {
        return temDao.findById(id).orElseThrow(() -> new Exception("Not found!"));
    }
}
