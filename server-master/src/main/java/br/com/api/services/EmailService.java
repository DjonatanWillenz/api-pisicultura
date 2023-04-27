package br.com.api.services;

import javax.persistence.criteria.Join;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.EmailDao;
import br.com.api.models.Email;
import br.com.api.models.UserSystem;
import br.com.api.utils.UtilsDate;

@Service
public class EmailService {

    @Autowired
    private EmailDao emailDao;

    @Transactional
    public Email save(String email, UserSystem user) {
        Email newEmail = new Email();
        newEmail.setEmail(email);
        newEmail.setDate(UtilsDate.getInstance().getDateCurrent());
        newEmail.setUser(user);
        newEmail = emailDao.save(newEmail);
        return newEmail;
    }

    public Email findByIdUser(Long iduser) {
        return emailDao.findAll((root, query, cb) -> {
            root.fetch("user");
            Join<?, ?> user = root.join("user");
            return cb.and(cb.equal(user.get("id"), iduser));
        }).get(0);
    }

}
