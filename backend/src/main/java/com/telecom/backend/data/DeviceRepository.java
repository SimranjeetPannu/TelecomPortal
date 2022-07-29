package com.telecom.backend.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.backend.beans.Device;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer>{
	
	
	public Device findById(int id);
	
	@Query("SELECT d FROM Device d")
	public List<Device> findAllDevices();


	public Device findByDeviceName(String deviceName);

	@Query(value="SELECT d FROM Device d WHERE d.planid = :planid")
    public List<Device> findDevicesByPlanid(@Param("planid") int planid);
}