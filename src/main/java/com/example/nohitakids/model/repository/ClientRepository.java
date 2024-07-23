package com.example.nohitakids.model.repository;

import com.example.nohitakids.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByName(String name);

    Optional<Client> findByDni(Integer dni);

    @Query(value = "SELECT buy FROM client ORDER BY buy ASC", nativeQuery = true)
    List<Integer> getAllQuantitiesOrderByBuyAsc();

    void deleteByDni(Integer dni);
}
