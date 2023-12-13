package com.example.s.present.request;

import com.example.s.core.domain.Dashboard;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardRequest {
    @NotBlank
    Object data;
    @NotBlank
    String teamId;

    public Dashboard ToDomain() {
        Dashboard dashboard = new Dashboard();
        dashboard.setData(this.getData());
        return dashboard;
    }
}
