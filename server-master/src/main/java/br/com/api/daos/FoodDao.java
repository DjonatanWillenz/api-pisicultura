package br.com.api.daos;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import br.com.api.models.Food;

@Repository
public interface FoodDao extends JpaRepositoryImplementation<Food, Long> {

}
