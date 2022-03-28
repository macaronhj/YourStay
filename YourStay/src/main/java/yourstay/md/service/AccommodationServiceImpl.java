package yourstay.md.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;
import yourstay.md.fileset.FileUtils;
import yourstay.md.fileset.RoomFileUtils;
import yourstay.md.mapper.AccommodationMapper;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationMapper accommodationMapper;
	
	@Resource(name="roomfileUtils")
	private RoomFileUtils roomfileUtils;
	
	/*
	 * 숙소 테이블에 등록
	 */
	@Override
	public void insertAccommodationS(Accommodation ac, MultipartHttpServletRequest mpRequest) throws Exception {
		
		
		List<Map<String,Object>> list = roomfileUtils.parseInsertFileInfo(ac, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			accommodationMapper.insertFile(list.get(i)); 
		}
		accommodationMapper.insert(ac);
	}
	


	/*
	 * 등록하는 회원번호 가져오기
	 */
	@Override
	public MemberVO getRegisterMemberSeqS(long mseq) {
		return accommodationMapper.getRegisterMemberSeq(mseq);
	}



}
