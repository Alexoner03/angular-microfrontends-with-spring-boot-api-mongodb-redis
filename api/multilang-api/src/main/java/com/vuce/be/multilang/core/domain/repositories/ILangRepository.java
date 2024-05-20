package com.vuce.be.multilang.core.domain.repositories;

import com.vuce.be.multilang.core.domain.entities.Lang;
import com.vuce.be.multilang.shared.application.errors.NotFoundError;

import java.util.HashMap;

public interface ILangRepository {
    Lang findByName(String name) throws NotFoundError;

    void save(Lang body, String name);
}
