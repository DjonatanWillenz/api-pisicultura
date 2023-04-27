package br.com.api.services;

import java.util.Optional;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.RequestPasswordDao;
import br.com.api.dtos.SendEmailDto;
import br.com.api.models.RequestPassword;
import br.com.api.models.UserSystem;
import br.com.api.utils.UtilsDate;
import br.com.api.utils.UtilsRandom;

@Service
public class RequestPasswordService {

    @Autowired
    private RequestPasswordDao requestPasswordDao;

    @Autowired
    private SendMailService sendMailService;

    @Transactional
    public boolean createRequestUpdatePassword(UserSystem user) {
        RequestPassword request = new RequestPassword();
        request.setConcluded(false);
        request.setDate(UtilsDate.getInstance().getDateCurrent());
        request.setKey(generateKey());
        request.setUser(user);

        requestPasswordDao.saveAndFlush(request);

        return sendMailService.save(
                SendEmailDto.builder()
                        .tomail(user.getEmail().getEmail())
                        .title("Código de verificação do usuário")
                        .body("Código de verificação:" + request.getKey())
                        .build());
    }

    public boolean validateKeyUpdatePassword(Long iduser, String key) throws Exception {
        return Optional.of(requestPasswordDao.findAll((root, query, cb) -> {
            root.fetch("user");
            Join<?, ?> users = root.join("user");
            return cb.and(
                    cb.equal(users.get("id"), iduser),
                    cb.equal(root.get("key"), key));
        })).orElseThrow(() -> new Exception("A Chave informada é invalida!")).size() > 0;
    }

    @Transactional
    public String createNewRegister(UserSystem user) {
        RequestPassword request = new RequestPassword();
        request.setUser(user);
        request.setDate(UtilsDate.getInstance().getDateCurrent());
        request.setConcluded(false);
        request.setKey(generateKey());
        return requestPasswordDao.saveAndFlush(request).getKey();
    }

    private String generateKey() {
        return UtilsRandom.getInstance().getNumberBetween(100000L, 2000000L).toString();
    }
}
