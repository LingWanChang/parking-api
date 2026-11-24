package com.example.parking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ParkingSpot {
    private Long id;

    @NotBlank(message = "車位編號不可空白")
    @Size(max = 20, message = "車位編號最多 20 個字")
    private String code;

    @NotBlank(message = "區域不可空白")
    @Size(max = 50, message = "區域最多 50 個字")
    private String area;

    @Pattern(regexp = "AVAILABLE|OCCUPIED", message = "狀態只能是 AVAILABLE 或 OCCUPIED")
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}