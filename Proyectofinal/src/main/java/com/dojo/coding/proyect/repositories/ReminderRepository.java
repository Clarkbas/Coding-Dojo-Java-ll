package com.dojo.coding.proyect.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.coding.proyect.models.Reminder;


@Repository
public interface ReminderRepository extends CrudRepository<Reminder, Long> {

    List<Reminder> findAll();
    List<Reminder> findTop10ByOrderByStartDateDesc();
    List<Reminder> findBydescriptionContainsAllIgnoreCase(String search);
}