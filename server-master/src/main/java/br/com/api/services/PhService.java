package br.com.api.services;

import java.util.List;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.PHDao;
import br.com.api.dtos.PhDto;
import br.com.api.models.Installation;
import br.com.api.models.PH;
import br.com.api.utils.UtilsDate;

@Service
public class PhService {

    @Autowired
    private PHDao phDao;

    @Autowired
    private InstallationService installationService;

    @Transactional
    public PH save(PhDto phDto) throws Exception {
        Installation installation = installationService.findById(phDto.getIdinstallation());
        PH ph = new PH();
        ph.setDate(UtilsDate.getInstance().getDateCurrent());
        ph.setInstallation(installation);
        ph.setRun(phDto.getRun());
        ph.setValue(phDto.getValue());
        return phDao.save(ph);
    }

    public List<PH> findByIdInstallation(Long id) {
        return phDao.findAll((root, query, cb) -> {
            root.fetch("installation");
            Join<?, ?> installation = root.join("installation");
            return cb.and(cb.equal(installation.get("id"), id));
        });
    }

    @Transactional
    public void deleteById(Long id) {
        phDao.deleteById(id);
    }
}
