package br.com.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.SendMailDao;
import br.com.api.dtos.SendEmailDto;
import br.com.api.enums.SendMailStateEnum;
import br.com.api.models.SendMail;
import br.com.api.utils.UtilsDate;

@Service
public class SendMailService {

    @Autowired
    private SendMailDao sendMailDao;

    @Transactional
    public boolean save(SendEmailDto dto) {
        SendMail email = new SendMail();
        email.setTomail(dto.getTomail());
        email.setTitle(dto.getTitle());
        email.setBody(dto.getBody());
        email.setDate(UtilsDate.getInstance().getDateCurrent());
        email.setState(SendMailStateEnum.PENDENTING);
        email.setAttempts(0L);
        return sendMailDao.saveAndFlush(email) != null;
    }

    public List<SendMail> findPending() {
        return sendMailDao.findAll((root, query, cb) -> cb.equal(root.get("state"), SendMailStateEnum.PENDENTING));
    }

    @Transactional
    public void path(SendMail mail) {
        sendMailDao.save(mail);
    }

}
