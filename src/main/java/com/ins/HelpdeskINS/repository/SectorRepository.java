package com.ins.HelpdeskINS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.ins.HelpdeskINS.entity.Sector;


public interface SectorRepository extends JpaRepository <Sector,Integer> {
 // JPQL
    @Query("FROM Sector s WHERE s.Sede.id =:sedID")
    List<Sector> buscarSectorporSede(Integer sedID);
}
