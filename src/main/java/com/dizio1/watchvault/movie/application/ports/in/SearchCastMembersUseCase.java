package com.dizio1.watchvault.movie.application.ports.in;

import com.dizio1.watchvault.movie.domain.model.CastMember;

import java.util.List;

public interface SearchCastMembersUseCase {

    List<CastMember> getCastMembers(String name);
}
