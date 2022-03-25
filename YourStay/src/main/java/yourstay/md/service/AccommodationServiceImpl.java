package yourstay.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;
import yourstay.md.mapper.AccommodationMapper;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationMapper accommodationMapper;
	
	/*
	 * 숙소 테이블에 등록
	 */
	@Override
	public void insertAccommodationS(Accommodation ac) {
		accommodationMapper.insertAccommodation(ac);
	}

	/*
	 * 이미지 테이블 등록
	 */
	@Override
	public void insertImageS(Image img) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 등록하는 회원번호 가져오기
	 */
	@Override
	public MemberVO getRegisterMemberSeqS(long mseq) {
		return accommodationMapper.getRegisterMemberSeq(mseq);
	}



}
