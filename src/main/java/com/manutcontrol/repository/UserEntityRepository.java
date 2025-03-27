package com.manutcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutcontrol.entities.UsersEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UsersEntity, Integer> {

}
