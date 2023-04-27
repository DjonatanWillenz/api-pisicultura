package br.com.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.LogDao;
import br.com.api.models.Log;
import br.com.api.utils.UtilsDate;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    @Transactional
    public void createLog(String message, String description, String logs, String processo) {
        Log log = new Log();
        log.setDate(UtilsDate.getInstance().getDateCurrent());
        log.setDecription(description);
        log.setLog(logs);
        log.setMessage(message);
        logDao.save(log);
    }
}
