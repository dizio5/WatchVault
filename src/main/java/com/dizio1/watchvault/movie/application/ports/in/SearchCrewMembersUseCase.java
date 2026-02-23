package com.dizio1.watchvault.movie.application.ports.in;

import com.dizio1.watchvault.movie.domain.model.CrewMember;

import java.util.List;

public interface SearchCrewMembersUseCase {

    List<CrewMember> getCrewMembers(String movieName);
}
