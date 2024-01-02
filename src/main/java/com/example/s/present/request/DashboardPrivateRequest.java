package com.example.s.present.request;

import com.example.s.core.domain.Dashboard;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardPrivateRequest {
    @NotBlank
    Object data;

    public Dashboard ToDomain() {
        Dashboard dashboard = new Dashboard();
        dashboard.setData(this.getData());
        return dashboard;
    }
}
