package com.GraphQlTuts.GraphQL.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GraphQlTuts.GraphQL.Entities.Address.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByStudentId(Integer studentId);
}
