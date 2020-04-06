package com.tryputs.backend.repository;

import com.tryputs.backend.entity.ApplicationUser;

public interface UserRepository extends AbstractRepository<ApplicationUser> {
    ApplicationUser findByUsername(String username);
}
