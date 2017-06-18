package tr.com.can.employeemeeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.com.can.employeemeeting.daos.MeetingDAO;
import tr.com.can.employeemeeting.entities.Meeting;

@Transactional
@Service("meetingService")
public class MeetingService {
	
	@Autowired
	private MeetingDAO meetingDao;
	
	public List<Meeting> listAll(){
		return meetingDao.list();
	}
	
	public Meeting findById(Integer id){
		return meetingDao.findById(id);
	}
	
	public Boolean saveMeeting(Meeting m){
		Boolean result = meetingDao.save(m);
		return result;
	}
	
	public Boolean updateMeeting(Meeting m){
		Meeting meet = meetingDao.findById(m.getId());
		if(meet != null){
			meet.setName(m.getName());
			meet.setDescription(m.getDescription());
			meet.setDepartment(m.getDepartment());
			meetingDao.update(meet);
			return true;
		}else{
			return false;
		}
	}
	
	   public Boolean deleteById(Integer id) {
	    	Meeting meet = meetingDao.findById(id);
	        if(meet != null){
	        	meetingDao.delete(meet);
	        	return true;
	        }else{
	        	return false;
	        }
	    }
}
