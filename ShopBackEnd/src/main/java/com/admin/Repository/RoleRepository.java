package com.admin.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.common.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role ,Long> {

}
