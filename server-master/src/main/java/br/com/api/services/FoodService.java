package br.com.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.daos.FoodDao;
import br.com.api.dtos.FoodDto;
import br.com.api.enums.FoodStateEnum;
import br.com.api.enums.RationEnum;
import br.com.api.enums.RunEnum;
import br.com.api.models.Food;
import br.com.api.models.Installation;
import br.com.api.utils.UtilsDate;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    @Transactional
    public void save(Installation installation, FoodDto foodDto) throws Exception {
        Food food = new Food();
        food.setDateCreate(UtilsDate.getInstance().getDateCurrent());
        food.setInstallation(installation);
        food.setRation(food.getRation());
        food.setRun(foodDto.getRun());
        food.setState(food.getState());
        foodDao.save(food);
    }

    public List<Food> getByIdInstallaction(Long id) {
        return foodDao.findAll((root, query, cb) -> cb.equal(root.get("installation"), id));
    }

    @Transactional
    public Boolean createRequest(Installation installation) throws Exception {
        Food food = new Food();
        food.setDateCreate(UtilsDate.getInstance().getDateCurrent());
        food.setInstallation(installation);
        food.setRation(RationEnum.AVERAGE);
        food.setRun(RunEnum.MANUAL);
        food.setState(FoodStateEnum.PENDING);
        return foodDao.saveAndFlush(food) != null;
    }
}
