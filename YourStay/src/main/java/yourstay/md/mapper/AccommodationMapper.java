package yourstay.md.mapper;

import java.awt.Image;
import java.util.Map;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.MemberVO;

public interface AccommodationMapper {

	/*
	 * 숙소 테이블에 등록
	 */
	public void insert(Accommodation ac);
	

	/*
	 * 이미지 테이블 등록
	 */
	public void insertFile(Map<String, Object> map) throws Exception;
	/*
	 * 등록하는 회원번호 가져오기
	 */
	public MemberVO getRegisterMemberSeq(long mseq);
}
