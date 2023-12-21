package com.example.s.present.request;

import com.example.s.core.domain.Team;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequest {
    @NotBlank
    String name;

    public Team ToDomain() {
        Team team = new Team();
        team.setName(this.getName());
        return team;
    }
}
