package com.example.parking.repository;

import com.example.parking.model.ParkingSpot;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ParkingSpotRepository {

    @Select("SELECT id, code, area, status FROM parking_spot ORDER BY id")
    List<ParkingSpot> findAll();

    @Select("SELECT id, code, area, status FROM parking_spot WHERE id = #{id}")
    Optional<ParkingSpot> findById(Long id);

    @Insert("INSERT INTO parking_spot (code, area, status) VALUES (#{code}, #{area}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ParkingSpot spot);

    @Update("UPDATE parking_spot SET code = #{code}, area = #{area}, status = #{status} WHERE id = #{id}")
    int update(ParkingSpot spot);

    @Delete("DELETE FROM parking_spot WHERE id = #{id}")
    int deleteById(Long id);

    default ParkingSpot save(ParkingSpot spot) {
        insert(spot);
        return spot;
    }
}