package br.com.api.services;

import br.com.api.daos.SettingsDao;
import br.com.api.dtos.SettingsDto;
import br.com.api.models.Settings;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    @Autowired
    private SettingsDao settingsDao;

    @Autowired
    private UserService userService;

    @Transactional
    public void save(SettingsDto settingsDto) {
        Settings setting = new Settings();
        setting.setNotify(settingsDto.isNotify());
        setting.setUser(userService.findById(settingsDto.getIduser()));
        settingsDao.save(setting);
    }

    @Transactional
    public void update(SettingsDto settingsDto) throws Exception {
        Settings setting = settingsDao.findById(settingsDto.getIduser())
                .orElseThrow(() -> new Exception("Configuração não encontrada para realizar a atualização!"));
        setting.setNotify(settingsDto.isNotify());
        setting.setUser(userService.findById(settingsDto.getIduser()));
        settingsDao.save(setting);
    }

    @Transactional
    public void delete(Long id) {
        settingsDao.deleteById(id);
    }

    public SettingsDto findById(Long id) {
        Optional<Settings> optional = settingsDao.findById(id);        
        if (optional.isPresent()) {        
            Settings settings = optional.get();      
            return SettingsDto.builder()
                    .iduser(settings.getUser().getId())
                    .notify(settings.isNotify())
                    .build();
        }
        return null;
    }

}
